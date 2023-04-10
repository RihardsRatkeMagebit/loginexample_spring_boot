import React from "react"
import { Navigate } from "react-router-dom"

export function Dashboard(props) {

    const result = () => {
        if (localStorage.getItem("token")) {
            return (
                <div className="Welcome-message">
                    <span>Hello </span><span>{props.username}</span>
                </div>
            )
        } else {
            return (
                <Navigate to="/"></Navigate>
            )
        }
    }


    return (
        <div className="dashbord-wrapper">
            {result()}
        </div>
    )
}