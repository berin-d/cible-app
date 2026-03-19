package com.cible.backend_cible.seeder;

import com.cible.backend_cible.db.task.PriorityRepository;
import com.cible.backend_cible.db.task.StatusRepository;
import com.cible.backend_cible.db.task.TaskGroupRepository;
import com.cible.backend_cible.db.task.TaskRepository;
import com.cible.backend_cible.db.task.UserRepository;
import com.cible.backend_cible.model.task.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("!prod") // ⚠️ Ne s'exécute JAMAIS en production
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final StatusRepository     statusRepository;
    private final PriorityRepository   priorityRepository;
    private final TaskGroupRepository  taskGroupRepository;
    private final TaskRepository       taskRepository;

    @Override
    @Transactional
    public void run(String... args) {

        if (taskRepository.count() > 0) {
            log.info("⏭️  DataSeeder — données déjà présentes, seed ignoré.");
            return;
        }

        log.info("🌱 DataSeeder — début de l'initialisation des données...");

        // ── 1. STATUTS ────────────────────────────────────────────────────────────
        Status todo       = status("À faire");
        Status inProgress = status("En cours");
        Status done       = status("Terminé");
        Status cancelled  = status("Annulé");
        statusRepository.saveAll(List.of(todo, inProgress, done, cancelled));

        // ── 2. PRIORITÉS ──────────────────────────────────────────────────────────
        Priority low    = priority("Basse");
        Priority medium = priority("Moyenne");
        Priority high   = priority("Haute");
        Priority urgent = priority("Urgente");
        priorityRepository.saveAll(List.of(low, medium, high, urgent));

        // ── 3. UTILISATEURS ───────────────────────────────────────────────────────
        User alice = user("Alice",   "alice@example.com",  "hashed_pwd_alice");
        User bob   = user("Bob",      "bob@example.com",    "hashed_pwd_bob");
        User clara = user("Clara",  "clara@example.com",  "hashed_pwd_clara");
        userRepository.saveAll(List.of(alice, bob, clara));

        // ── 4. GROUPES DE TÂCHES ──────────────────────────────────────────────────
        TaskGroup work     = group("Travail",    alice);
        TaskGroup personal = group("Personnel",  alice);
        TaskGroup studies  = group("Études",     bob);
        TaskGroup projects = group("Projets",    bob);
        TaskGroup health   = group("Santé",      clara);
        taskGroupRepository.saveAll(List.of(work, personal, studies, projects, health));

        // ── 5. TÂCHES ─────────────────────────────────────────────────────────────
        LocalDateTime now = LocalDateTime.now();

        List<Task> tasks = List.of(

            // Alice – Travail
            task("Préparer la réunion client",
                 "Rassembler les slides et KPIs du trimestre.",
                 now.plusDays(2),  alice, inProgress, high,   work,     1),

            task("Rédiger le rapport mensuel",
                 "Synthèse des activités de mars 2026.",
                 now.plusDays(5),  alice, todo,       medium, work,     2),

            task("Revoir les contrats fournisseurs",
                 "Vérifier les clauses de renouvellement.",
                 now.plusDays(10), alice, todo,       low,    work,     3),

            // Alice – Personnel
            task("Planifier les vacances d'été",
                 "Comparer les destinations et réserver les billets.",
                 now.plusDays(30), alice, todo,       low,    personal, 1),

            task("Faire les courses de la semaine",
                 "Liste : légumes, pâtes, yaourts, pain.",
                 now.plusDays(1),  alice, done,       low,    personal, 2),

            // Bob – Études
            task("Rendre le devoir de maths",
                 "Exercices p. 142 à 148 du manuel.",
                 now.plusDays(3),  bob, inProgress, urgent, studies,  1),

            task("Lire le chapitre 5 d'algo",
                 "Arbres binaires de recherche et AVL.",
                 now.plusDays(4),  bob, todo,       medium, studies,  2),

            task("Préparer la soutenance",
                 "Préparer les slides et la démo du projet fil rouge.",
                 now.plusDays(14), bob, todo,       high,   studies,  3),

            // Bob – Projets
            task("Intégrer l'API paiement",
                 "Stripe v3 — gérer webhooks et remboursements.",
                 now.plusDays(7),  bob, inProgress, high,   projects, 1),

            task("Écrire les tests unitaires",
                 "Couvrir les services TaskService et UserService à 80 %.",
                 now.plusDays(6),  bob, todo,       medium, projects, 2),

            task("Mettre en place la CI/CD",
                 "Pipeline GitHub Actions → build, test, deploy sur Railway.",
                 now.plusDays(12), bob, todo,       high,   projects, 3),

            // Clara – Santé
            task("Rendez-vous médecin généraliste",
                 "Bilan annuel + renouvellement ordonnance.",
                 now.plusDays(8),  clara, todo,      medium, health,   1),

            task("Séance sport 3×/semaine",
                 "Lundi, mercredi, vendredi — 30 min cardio.",
                 now.plusDays(1),  clara, inProgress, medium, health,  2),

            task("Commander les vitamines D",
                 "Boîte de 90 gélules 1000 UI.",
                 now.plusDays(2),  clara, cancelled,  low,    health,  3),

            // Tâche sans groupe (group = null)
            task("Archiver les anciens projets",
                 "Nettoyer le disque et zipper les dossiers de 2024.",
                 now.plusDays(20), clara, todo, low, null, 1)
        );

        taskRepository.saveAll(tasks);

        log.info("✅ DataSeeder — {} tâches insérées avec succès.", tasks.size());
    }

    // ── Helpers ───────────────────────────────────────────────────────────────────

    private Status status(String label) {
        Status s = new Status();
        s.setName(label);
        return s;
    }

    private Priority priority(String label) {
        Priority p = new Priority();
        p.setName(label);
        return p;
    }

    private User user(String username, String email, String password) {
        User u = new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password); // ⚠️ en prod : utiliser BCryptPasswordEncoder
        return u;
    }

    private TaskGroup group(String name, User owner) {
        TaskGroup g = new TaskGroup();
        g.setName(name);
        g.setUser(owner);
        return g;
    }

    private Task task(String title,
                      String description,
                      LocalDateTime dueDate,
                      User user,
                      Status status,
                      Priority priority,
                      TaskGroup group,
                      int order) {
        Task t = new Task();
        t.setTitle(title);
        t.setDescription(description);
        t.setDueDate(dueDate);
        t.setUser(user);
        t.setStatus(status);
        t.setPriority(priority);
        t.setTaskGroup(group);   // peut être null
        t.setTaskOrder(order);
        // completedAt rempli seulement si la tâche est "Terminée"
        if ("Terminé".equals(status.getName())) {
            t.setCompletedAt(LocalDateTime.now().minusHours(2));
        }
        return t;
    }
}
