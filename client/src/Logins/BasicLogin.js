import { useState, useEffect } from 'react';
import styled from 'styled-components';
import { LogButton } from '../style/Style';
import { Input } from '../style/Style';
import { useNavigate } from 'react-router-dom';
import { useRecoilState } from "recoil";
import axios from "axios";
import { loginState } from '../store/atom';


const BasicContainer = styled.div`
  border: 1px solid black;
  width: 100%;
  max-width: 288px;
  padding: 24px;
  margin-bottom: 24px;
  background: #fff;
  border-radius: 7px;
  box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
    0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);
  div {
    display: flex;
    flex-direction: column;
    width: 100%;
    max-width: 288px;
    label {
      font-size: 15px;
      font-weight: bold;
    }
    button {
      margin: 0;
    }
    p {
      margin: 2px;
      padding: 2px;
      color: #d0390e;
      font-size: 12px;
    }
  }
  .login-email {
    margin-bottom: 10px;

  }
  .login-password {
    margin-bottom: 20px;


  }
`;

const BasicLogin = () => {
  const initialInfo = { email: '', password: '' };
  const [loginInfo, loginInfoSet] = useState(initialInfo);
  const [emptyEmail, emptyEmailSet] = useState(false);
  const [emptyPassword, emptyPasswordSet] = useState(false);
  const [invalidEmail, invalidEmailSet] = useState(false);
  const [invalidPassword, invalidPasswordSet] = useState(false);
  const [loginFailed, loginFailedSet] = useState(false);
  const [login,setLogin] = useRecoilState(loginState);
  const [token, setToken] = useState('');



  const navigate = useNavigate();




 

  const handeLogin = async(email, password) => {
    // eslint-disable-next-line
    const emailRegex = /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
    const passwordRegex = /^[A-Za-z\d!@#$%^&*()_+~\-=]{8,40}$/;

    // 비어있으면 empty메세지 출력
    if (email === '') emptyEmailSet(true);
    // 유효하지않으면(이메일 형식) invalid 메세지 출력
    else if (!emailRegex.test(email)) {
      emptyEmailSet(false);
      invalidEmailSet(true);
    }

    // 비어있으면 empty메세지 출력
    if (password === '') emptyPasswordSet(true);
    // 유효하지않으면(8자 이상) invalid 메세지 출력
    else if (!passwordRegex.test(password)) {
      emptyPasswordSet(false);
      invalidPasswordSet(true);
    }

    // login 전송 , 성공시 Common페이지 이동 및 loginstate true로 변경
    if (email && password && emailRegex.test(email) && passwordRegex.test(password)) {
      try {
        const response = await axios.post('https://5517-124-111-225-247.ngrok-free.app/auth/login', {
          username: email,
          password: password,
        });

        // Extract the JWT token from the response and store it in state
        setToken(response.data.token);

        // Update the login state with the user's email and token
        setLogin({
          username: email,
          token: response.data.token,
        });

        // Navigate to the home page on successful login
        navigate('/');

      } catch (error) {
        // handle failed login
        console.error(error.response.data.message);
        loginFailedSet(true);
      }
    }

  };

  return (
    <BasicContainer className="basic-container">
      <div className="login-email">
        <label htmlFor="email">Email</label>
        <Input
          id="email"
          type="email"
          value={loginInfo.email}
          onChange={(event) =>
            loginInfoSet({ ...loginInfo, email: event.target.value })
          }
          border={emptyEmail || loginFailed ? '#d0390e' : null}
          focusBorder={emptyEmail || loginFailed ? '#d0390e' : null}
          shadow={emptyEmail || loginFailed ? 'rgb(246,224,224)' : null}
        />
        {emptyEmail ? <p>Email cannot be empty.</p> : null}
        {invalidEmail ? <p>The email is not a valid email address.</p> : null}
        {loginFailed ? <p>The email or password is incorrect.</p> : null}
      </div>
      <div className="login-password">
        <label htmlFor="email">Password</label>
        <Input
          id="password"
          type="password"
          value={loginInfo.password}
          onChange={(event) =>
            loginInfoSet({ ...loginInfo, password: event.target.value })
          }
          border={emptyEmail || loginFailed ? '#d0390e' : null}
          focusBorder={emptyEmail || loginFailed ? '#d0390e' : null}
          shadow={emptyEmail || loginFailed ? 'rgb(246,224,224)' : null}
        />
        
        {emptyPassword ? <p>Password cannot be empty.</p> : null}
        {invalidPassword ? (
          <p>The password must be at least 8 characters long.</p>
        ) : null}
        {loginFailed ? <p>The email or password is incorrect.</p> : null}
      </div>
      <div>
        <LogButton
          bgColor="var(--blue-500)"
          color="#fff"
          border="transparent"
          onClick={() => handeLogin(loginInfo.email, loginInfo.password)}
        >
          Log in
        </LogButton>
      </div>
    </BasicContainer>
  );
};

export default BasicLogin;