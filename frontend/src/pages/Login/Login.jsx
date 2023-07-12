import React, { useState } from 'react';

import { useNavigate } from 'react-router-dom';

import "./Login.css";

const logo = "https://upload.wikimedia.org/wikipedia/commons/6/67/NewNetflixLogo.png";

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    async function handleLogin(e) {
        e.preventDefault();

        await fetch(`http://localhost:8080/auth/login?email=${email}&password=${password}`, {
            method: 'POST'
        })
        .then((res) => res.json())
        .then((data) => {
            alert(data.message)

            if (data.message == "Login Realizado! Conectando..") {
                navigate('/home', { state: { userId: data.id} });
            }
        })

    };

    return (
        <>
        <img className="nav-logo-login" src={logo} alt="NetFlix"></img>
        <div className="login-container">
            <form onSubmit={handleLogin}>
                <h1>Login</h1>
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={handleEmailChange}
                />
                <input
                    type="password"
                    placeholder="Senha"
                    value={password}
                    onChange={handlePasswordChange}
                />
                <button type="submit">Entrar</button>
            </form>
        </div>
        </>
    );
}

export default Login