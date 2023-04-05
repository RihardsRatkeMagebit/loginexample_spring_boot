import { useState } from "react"
import "./LoginForm.css"

export function LoginForm() {
    let [username, setUsername] = useState();
    let [password, setPassword] = useState();
    let [message,setMessage] = useState();

    const updatePassword = (e) => {
        setPassword(e.target.value);
    }

    const updateEmail = (e) => {
        setUsername(e.target.value);
    }

    const doLogin = ()=>{
        let loginDTO = {
            username:username,
            password:password
        }

        fetch("http://localhost:8080/api/v1/auth/login",{
            method:"POST",
            mode:"cors",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(loginDTO)
        }).then(res => {
            debugger;
            if (!res.ok){
                setMessage("Fetch failed, try again later")
            }

            res.json().then(data => {
                if (data.token == null){
                    setMessage("Invalid login or password")
                }
                localStorage.setItem("token",data.token)
                setMessage("User logged in")
            });
        }).catch(e => {
            setMessage("Try again late")
        })
    }

    return (
    <div>
        <div className="message">
            {message}
        </div>
        <div className="login-wrapper">
            <form>
                <label htmlFor="email">Email</label>
                <input type="input" onChange={updateEmail} name="email"></input>
                <label htmlFor="password">Password</label>
                <input type="password" autoComplete="true" onChange={updatePassword} name="password"></input>
                <button type="button" onClick={doLogin}>Submit</button>
            </form>
        </div>
    </div>
    )
}