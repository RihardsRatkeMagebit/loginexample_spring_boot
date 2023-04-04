import './App.css';
import { Login } from './app/components/login/Login';
import { Dashboard } from './app/components/dashboard/Dashboard';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Routes>
          <Route path='/' element={<Login />}>
          </Route>
          <Route path='/dashboard' element={<Dashboard />} >
          </Route>
        </Routes>
      </header>
    </div>
  );
}

export default App;
