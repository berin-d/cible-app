import Button from "../../components/commons/button"
import { NavLink } from "react-router-dom";
import { useState } from "react";
import Modal from "../../components/commons/modal";
import LoginForm from "../../components/form/loginForm";
import RegisterForm from "../../components/form/registerForm";
import icon from "../../assets/app-icon.png";
import { faDownload } from "@fortawesome/free-solid-svg-icons";


export default function WelcomePage() {
    const [modalOpen, setModalOpen] = useState(false);
    const [isLogin, setIsLogin] = useState(true);

    return (
        <div className="min-h-screen bg-[#09090b]">
            <header className="flex w-full px-6 md:px-12 items-center bg-[#090a0c]/80 border-b border-white/5">

                <div className="flex-1 flex items-center">
                    <img src={icon} alt="Logo" className="h-10 w-auto" />
                </div>

                <nav className="flex-1 flex justify-center">
                    <NavLink
                        className="font-medium text-white hover:text-green-400 transition-colors hover:cursor-pointer"
                        to="/"
                    >
                        Changelog
                    </NavLink>
                </nav>

                <nav className="flex-1 flex justify-end items-center p-2 space-x-4">
                    <p className="font-medium text-white hover:text-green-400 transition-colors hover:cursor-pointer" onClick={() => { setModalOpen(!modalOpen); setIsLogin(true) }}>Log in</p>
                    <Button
                        text="Download"
                        iconName={faDownload}
                        variant="primary"
                        size="md"
                        />
                </nav>
            </header>

            <main className="min-h-screen flex flex-col pt-24 md:pt-32">
                {/* Hero Section */}
                <section className="flex flex-col flex items-center justify-center">
                    <div className="text-center max-w-4xl mx-auto pr-6 pl-6">
                        <div className="inline-flex items-center gap-2 px-3 py-1 rounded-full border mb-8 border-white/10 bg-white/5">
                            <span className="flex h-2 w-2 rounded-full bg-emerald-500 animate-pulse"></span>
                            <span className="text-[10px] uppercase tracking-wider font-medium text-zinc-300">v1.0 is now live</span>
                        </div>

                        <h1 className="md:text-7xl leading-[1.15] text-5xl font-medium text-white  mb-6">
                            Structure your chaos into <span className="text-transparent bg-clip-text bg-gradient-to-r from-emerald-400 to-emerald-600">clarity</span>
                        </h1>

                        <p className="text-lg text-zinc-500 max-w-xl mx-auto mb-10 font-light leading-relaxed">
                            A minimal workspace designed for high-leverage individuals. Connect your daily tasks to your life's actual purpose without the noise.
                        </p>

                        <div className="flex flex-col sm:flex-row items-center justify-center gap-4">
                        <Button
                            text="Get Started"
                            variant="primary"
                            size="md"
                            animation="scale"
                            />
                        </div>
                    </div>

                </section>

                {/* Create Task */}
                <section
                    className="max-w-7xl mx-auto px-6 md:px-12 py-24 grid md:grid-cols-2 gap-16 items-center"
                >


                </section>
                <Modal isOpen={modalOpen} onClose={() => setModalOpen(false)} title="Welcome Back">
                    {isLogin ? (
                        <>
                            <LoginForm />
                            <div className="text-center p-2">
                                <span className="text-gray-400">Don't have an account? </span>
                                <p onClick={() => setIsLogin(false)} className="text-primary-400 hover:text-primary-300 hover:cursor-pointer">
                                    Sign up
                                </p>
                            </div>
                        </>
                    ) : (
                        <>
                            <RegisterForm />
                            <div className="text-center p-2">
                                <span className="text-gray-400">Already have an account? </span>
                                <p onClick={() => setIsLogin(true)} className="text-primary-400 hover:text-primary-300 hover:cursor-pointer">
                                    Log in
                                </p>
                            </div>
                        </>
                    )}
                </Modal>
            </main >


            <footer>
                <div>
                    <p className="text-center text-white p-5">© 2026</p>
                </div>
            </footer>

        </div >

    )
}