import Button from "../../components/commons/button";
import Modal from "../../components/commons/modal";

import { useState } from "react";

export default function TaskPage() {
    const [modalOpen, setModalOpen] = useState(false);

    return (
        <div>
            <header className="flex justify-between items-center p-2">
                <h1 className="text-2xl font-bold text-white">Tasks</h1>
                <Button onClick={() => setModalOpen(!modalOpen)} text="New task" iconName="plus"></Button>
            </header>

            <main>
                <Modal isOpen={modalOpen} onClose={() => setModalOpen(false)} title="Welcome back" >
                    <form>
                    </form>
                </Modal>
            </main>
        </div >
    )
}