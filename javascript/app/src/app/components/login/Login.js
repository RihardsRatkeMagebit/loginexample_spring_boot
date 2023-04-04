import { useState } from "react"
import './Login.css';

export function Login() {
    let [username, setUsername] = useState();
    let [password, setPassword] = useState();
    let [message, setMessage] = useState();

    const handleUsernameField = (e) => {
        setUsername(e.target.value)
    }

    const handlePasswordField = (e) => {
        setPassword(e.target.value)
    }

    const login = () => {
        let data = {
            username: username,
            password: password
        }

        fetch("http://localhost:8080/api/v1/auth/login", {
            method: "POST",
            mode: "cors",
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json',
            },
        }).then((response) => {
            if (!response.ok) {
                setMessage("Incorrect username or password")
            }

            response.json().then(data => {
                if (data && data.token.length) {
                    setMessage("User logged in");
                    localStorage.setItem("token", data.token)
                } else {
                    localStorage.setItem("token", null)
                    setMessage("Something went wrong, check login or password")
                }
            })
        }).catch((e) => {
            setMessage("Fetching failed")
            console.log(e);
        })

    }

    return (
        <div className="login-page">
            <div className="message-block">{message}</div>
            <div className="login-wrapper">
                <form className="form">
                    <fieldset className="fieldset">
                        <label className="label" htmlFor="username">Username:</label>
                        <input className="input"
                            onChange={handleUsernameField}
                            name="username"
                            placeholder="Please enter a username"
                        ></input>
                    </fieldset>
                    <fieldset className="fieldset">
                        <label className="label" htmlFor="password">Password:</label>
                        <input className="input"
                            onChange={handlePasswordField}
                            type="password"
                            autoComplete="true"
                            name="password"
                            placeholder="Please enter a password"
                        ></input>
                    </fieldset>
                    <button type="button" onClick={login} className="button">Login</button>
                </form>
            </div>
        </div>
    )
}