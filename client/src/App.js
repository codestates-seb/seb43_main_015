import './App.css';
import { RecoilRoot } from "recoil";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from './pages/Header';
import Main from './pages/Main';
import Login from './pages/Login';
import SignUp from './pages/SignUp';
import styled, { ThemeProvider } from "styled-components";
import theme from "./style/theme";

function App() {
  return (
    <ThemeProvider theme={{theme}}>
      <RecoilRoot>
          <Router>
            <Header/>
            <Routes>
              <Route path="/" element={<Main />} />
              <Route path="/login" element={<Login />} />
              <Route path="/signup" element={<SignUp />} />
            </Routes>
          </Router>
      </RecoilRoot>
    </ThemeProvider>
  );
}

export default App;
