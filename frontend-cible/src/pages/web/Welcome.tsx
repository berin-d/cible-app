import Button from "../../components/commons/button"
import logo from "../../assets/app-icon.png"
import { useRef, useState, useEffect } from 'react';
import { NavLink } from "react-router-dom";



export default function WelcomePage() {
    const [taskDoneCount, setTaskDoneCount] = useState(0);
    const [isVisible, setIsVisible] = useState(false);

    const handleLogoClick = () => {
        setTaskDoneCount(taskDoneCount + 1);
        setIsVisible(true);

        setTimeout(() => {
            setIsVisible(false);
        }, 3000);

    };


    return (
        <div className="min-h-screen bg-[#1A1A1E]">
            {/* Navigation Section */}
            <header className="fixed top-0 w-full px-8 md:px-12 flex items-center z-50 bg-[#242429]/80 backdrop-blur-sm">
                <nav className="flex gap-2 items-center p-2 w-full justify-between">
                    <Button text="Download" label="" iconName="download"></Button>
                    <NavLink className="font-medium hover:text-green-400 transition-colors hover:cursor-pointer text-white" to="/login">LOGIN / SIGN UP </NavLink>

                </nav>
            </header>

            <main className="min-h-screen flex flex-col pt-24 md:pt-32">
                {/* Hero Section */}
                <section className="flex flex-col flex items-center justify-center py-12">
                    <div className="flex flex-col justify-center items-center animation">
                        <p className={` ${isVisible ? 'opacity-100' : 'opacity-0'} text-white font-medium uppercase transition-opacity duration-200 ease-in-out `}>✅ {taskDoneCount}</p>
                        <img src={logo} alt="logo"
                            className="size-64 transform transition-transform duration-200 cursor-pointer hover:-translate-y-1 active:scale-95"
                            onClick={handleLogoClick} ></img>
                        <h1 className="text-white text-4xl text-center mt-4 font-bold uppercase">Turn Tasks Into Progress</h1>
                    </div>
                    <div className="pt-10 flex justify-center">
                        <Button text="Download" iconName="download" label="" ></Button>
                    </div>
                </section>

                {/* Create Task */}
                <section
                    className="max-w-7xl mx-auto px-6 md:px-12 py-24 grid md:grid-cols-2 gap-16 items-center"
                >

                    <div className="space-y-6">
                        <h2 className="text-4xl md:text-5xl font-bold text-white">Créez vos tâches en un clic</h2>
                        <p className="text-lg leading-relaxed text-white">
                            Ajoutez rapidement vos tâches avec des descriptions détaillées, des dates limites et des priorités.
                            Organisez votre travail de manière intuitive et efficace.
                        </p>
                    </div>

                    <div className="rounded-2xl p-8 border-2 hover:shadow-purple-500/20 backdrop-blur-sm">
                        <div className="space-y-4">
                            <div className="bg-white/5 p-5 rounded-r-xl border-l-4 border-green-500 backdrop-blur-md animate-slide-in-left">
                                <div className="font-semibold mb-1 text-white">✅ Designer la page d'accueil</div>
                                <div className="text-sm text-gray-400">Priorité: Haute • Due: 25 Jan</div>
                            </div>
                            <div className="bg-white/5 p-5 rounded-r-xl border-l-4 border-green-500 backdrop-blur-md animate-slide-in-left animation-delay-200">
                                <div className="font-semibold mb-1 text-white">📱 Développer l'app mobile</div>
                                <div className="text-sm text-gray-400">Priorité: Moyenne • Due: 30 Jan</div>
                            </div>
                            <div className="bg-white/5 p-5 rounded-r-xl border-l-4 border-green-500 backdrop-blur-md animate-slide-in-left animation-delay-400">
                                <div className="font-semibold mb-1 text-white">🚀 Lancer la v1.0</div>
                                <div className="text-sm text-gray-400">Priorité: Haute • Due: 15 Fév</div>
                            </div>
                        </div>
                    </div>
                </section>

                {/* kanban */}
                <section className="">
                    <div className="flex items-center justify-between">
                        <div>

                        </div>
                        <div>

                        </div>

                    </div>

                </section>
            </main >


            <footer>
                <div>
                    <p className="text-center text-white p-5">© 2026</p>
                </div>
            </footer>

        </div >

    )
}