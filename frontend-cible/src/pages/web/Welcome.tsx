import Button from "../../components/commons/button"
import logo from "../../assets/app-icon.png"
import { useState } from 'react';



export default function WelcomePage() {
    const [taskDoneCount, setTaskDoneCount] = useState(0);

    const handleLogoClick = () => {
        setTaskDoneCount(taskDoneCount + 1);


    };


    return (
        <div className="min-h-screen">
            {/* Navigation Section */}
            <header className="fixed top-0 w-full px-8 md:px-12 py-5 flex items-center z-50 text-white">
                <nav className="flex gap-2 items-center p-2 w-full justify-between">
                    <Button text="Download" label=""></Button>
                    <a className="font-medium hover:text-green-400 transition-colors hover:cursor-pointer">LOGIN / SIGN UP</a>
                </nav>
            </header>


            <main className="bg-[#1A1A1E] min-h-screen flex justify-center items-center">
                {/* Hero Section */}
                <section>
                    <div className="flex flex-col justify-center items-center">
                        <p className="text-white font-medium uppercase">Task done :  {taskDoneCount}</p>
                        <img src={logo} alt="logo"
                            className="size-64 transform transition-transform duration-200 cursor-pointer hover:-translate-y-1  active:scale-95"
                            onClick={handleLogoClick} ></img>
                        <h1 className="text-white text-4xl text-center mt-4 font-bold uppercase">Turn Tasks Into Progress</h1>
                    </div>
                    <div className="pt-10 flex justify-center">
                        <Button text="Download" iconName="download" label="" ></Button>
                    </div>
                </section>


                {/* Create Task */}
                <section>


                </section>

                {/* kanban */}
                <section>


                </section>
            </main >

        </div >

    )
}