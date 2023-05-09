import { useRecoilState } from "recoil";
import { LoginPage, Login_container } from '../style/Style';
import { Link } from "react-router-dom";
import { ReactComponent as LoginLogo } from "../images/loginlogo.svg";
import SocialLogin from "../Logins/SocialLogin";
import BasicLogin from '../Logins/BasicLogin';



const Login = () => {
    return(
        <> 
            <LoginPage>
                <Login_container>
                    <div className='login_logo'>
                        <Link to="/">
                            <LoginLogo />
                        </Link>
                    </div>
                    <SocialLogin />
                    <BasicLogin />
                </Login_container>
            </LoginPage>
        </>
    )
}

export default Login;