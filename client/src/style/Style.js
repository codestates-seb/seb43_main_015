import styled, {css} from 'styled-components';
import theme from './theme';

export const HeaderContainer = styled.div`
    width: 100%;
    position: fixed;
    z-index: 10;
    height: 64px;
    border-top: 3px solid var(--orange-400);
    background-color: var(--black-025);
    display: flex;
    justify-content: center;
    align-items: center;
    box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
        0 2px 8px hsla(0, 0%, 0%, 0.05);
    background-color: ${({ theme }) => theme.black025};
`
export const Header_container = styled.div`
     width: 1264px;
    max-width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: white;
`


export const Logo = styled.h1`
    height: 100%;
    margin: 0;
    padding: 0 8px;
    display: flex;
    align-items: center;
`

export const Logo_img = styled.img`
    display: block;
    width: 150px;
    height: 30px;
    margin-top: -4px;
`

export const Gnb = styled.ul`
    display: flex;
    align-items: center;
    padding: 2px 0;
    margin: -2px;
    color: var(--black-600);
    font-size: 13px;
`
export const Gnb_ul = styled.ul`
    font-size: 18px;
    cursor: pointer;
`

export const Button_Container = styled.div`
    display: flex;
`

export const Login_Button = styled.button`
    background-color: #E1ECF4;
    margin: 4px;
    padding: 10px;
    box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
    border-radius: 3px;
    color: #39739D;
    font-size: 13px;
    border: 1px solid  'var(--blue-600)';
    opacity:  0.5;
    font-size: 13px;
    cursor : pointer;


    &:hover {
        background-color: #0A95FF;
        color: #fff;
    }
`
export const SignUp_Button = styled.button`
    background-color: #0A95FF;
    margin: 4px;
    padding: 10px;
    box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
    border-radius: 3px;
    color: #FFFFFF;
    font-size: 13px;
    border: 1px solid  'var(--blue-600)';
    opacity:  0.5;
    font-size: 13px;
    cursor : pointer;

    &:hover {
        background-color: #FFFFFF;
        color: #0A95FF;
    }
`

export const LoginPage = styled.section`
  width: 100%;
  height: 100vh;
  padding-top: 50px;
  display: flex;
  justify-content: center;
  background-color: var(--black-050);
`
export const Login_container = styled.div`
    width: 100%;
    max-width: 1264px;
    padding: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`

export const GoogleButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color:  '#fff';
  padding: 10px;
  margin: 4px 0;
  border: 1px solid 'var(--black-100)';
  border-radius: 5px;
  font-size: 13px;
  color: 'var(--black-700)';
  outline: none;
  > svg {
    margin-right: 5px;
  }
`;
export const GitButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color:  '#fff';
  padding: 10px;
  margin: 4px 0;
  border: 1px solid 'var(--black-100)';
  border-radius: 5px;
  font-size: 13px;
  color: '#fff';
  outline: none;
  > svg {
    margin-right: 5px;
  }
`;
export const FacebookButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color:  '#385499';
  padding: 10px;
  margin: 4px 0;
  border: 1px solid 'var(--black-100)';
  border-radius: 5px;
  font-size: 13px;
  color: '#fff';
  outline: none;
  > svg {
    margin-right: 5px;
  }
`;

export const LogButton = styled.button`
  background-color: #E1ECF4;
  margin: 4px;
  padding: 10px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border-radius: 3px;
  color: #39739D;
  font-size: 13px;
  border: 1px solid  'var(--blue-600)';
  opacity:  0.5;
  font-size: 13px;
  cursor : pointer;


  &:hover {
    background-color: #0A95FF;
    color: #fff;
  }
`;

const commonInput = css`
  width: 100%;
  margin-top: 5px;
  padding: 8px 9px;
  background-color: #fff;
  color: hsl(210, 8%, 5%);
  font-size: 13px;
  border: 1px solid  'var(--black-200)';
  border-radius: 3px;
  outline: none;
  &:focus {
    box-shadow: 0px 0px 0px 4px
       'var(--powder-100)';
    border-color: 'var(--blue-600)';
  }
`;

export const Input = styled.input`
  ${commonInput}
`;

export const Textarea = styled.textarea`
  height:  '280px';
  resize: vertical;
  ${commonInput}
`;

export const CommonButton = styled.button`
  background-color: #E1ECF4;
  margin: 4px;
  padding: 10px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border-radius: 3px;
  color: #39739D;
  font-size: 13px;
  border: 1px solid  'var(--blue-600)';
  opacity:  0.5;
  font-size: 13px;
  cursor : pointer;


  &:hover {
    background-color: #0A95FF;
    color: #fff;
  }
`;