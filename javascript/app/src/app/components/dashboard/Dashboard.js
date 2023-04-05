import React from "react"

export function Dashboard(props) {

    return (
        <div className="Welcome-message">
            <span>Hello </span><span>{props.username}</span>
        </div>
    )
}