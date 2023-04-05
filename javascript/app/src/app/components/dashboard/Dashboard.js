import React, { useEffect } from "react"
import { useNavigate } from "react-router-dom"

export function Dashboard(props) {
    let navigate = useNavigate()

    const handleRedirect = () => {
        navigate('/');
    }
    return (
        <div className="Welcome-message">
            <span onClick={handleRedirect}>Hello </span><span>{props.username}</span>
        </div>
    )
}