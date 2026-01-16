
function LoginPage() {
    return (
        <div className="flex flex-col items-center justify-center w-screen h-screen l bg-[#1A1A1E] gap-2 p-5">
            <div className="text-white">
                <p>Username</p>
                <input 
                className="bg-[#3B3B3F] border-0 border-emerald-500 rounded-md p-2"
                placeholder="Enter your username.."/>
            </div>
            <div className="text-white">
                <p>Password</p>
                <input 
                className="bg-[#3B3B3F] border-0 border-emerald-500 rounded-md p-2 text-white" 
                placeholder="Enter your password..."/> 
            </div>
            <div>
                <button className="bg-[#50C878] border-0 rounded-md p-1 pl-5 pr-5 hover:bg-[#2c7544]">Login</button>
            </div>
        </div>
    );
}


export default LoginPage;
