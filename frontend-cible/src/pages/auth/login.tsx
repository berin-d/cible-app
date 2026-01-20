import Button from "../../components/commons/button";
import Input from "../../components/commons/input";
import logo from "../../assets/logo-cible.png"

function LoginPage() {
    return (
        <div className="flex flex-col items-center justify-center w-screen h-screen l bg-[#1A1A1E] gap-2 p-5">
        <div className="pb-5">
            <img src={logo} className="size-48"></img>
        </div>
        <div>
            <Input label="Username" placeholder="Your username..."/>
            <Input label="Password" placeholder="Your password.."/>
            <Button text="Login" label="" color="primary"/>
        </div>
        </div>
    );
}


export default LoginPage;
