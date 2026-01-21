import Button from "../../components/commons/button"
import logo from "../../assets/app-icon.png"


export default function WelcomePage() {
    return (
        <div >
            <header className="flex justify-end bg-[#242429] text-white p-2">
                <nav className="flex gap-2 items-center p-2">
                    <Button text="Download"></Button>
                    <a>Login</a>
                </nav>
            </header>

            <main className="bg-[#1A1A1E] h-screen">
                <div>

                    <div className="flex flex-col justify-center items-center">
                        <img src={logo} alt="logo" className="size-64"></img>
                        <h1 className="text-white text-4xl text-center mt-4 font-bold">Turn Tasks Into Progress</h1>
                    </div>
                    <div className="pt-10 flex justify-center">
                        <Button text="Download" iconName="download" ></Button>
                    </div>

                </div>
            </main>

        </div>

    )
}