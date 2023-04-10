import './App.css';
import { Login } from './app/components/login/Login';
import { Dashboard } from './app/components/dashboard/Dashboard';
import { Route, Routes } from 'react-router-dom';
import { useEffect, useState } from 'react';

function App() {

  let [username, setUsername] = useState("");

  const pullUsername = (data => {
    setUsername(data)
  })

  useEffect(() => {
    if (localStorage.getItem("username")) {
      setUsername(localStorage.getItem("username"))
    }
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <Routes>
          <Route path='/' element={<Login pullData={pullUsername} />}>
          </Route>
          <Route path='/dashboard' element={<Dashboard username={username} />} >
          </Route>
        </Routes>
      </header>
    </div>
  );
}

export default App;
