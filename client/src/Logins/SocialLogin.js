import styled from "styled-components";
import { GoogleButton, GitButton, FacebookButton } from "../style/Style";
import { ReactComponent as GoogleLogo } from "../images/google-logo.svg";
import { ReactComponent as GitHubLogo } from "../images/github-logo.svg";
import { ReactComponent as FacebookLogo } from "../images/facebook-logo.svg";

const SocialContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 288px;
  margin: 24px 0 16px;
  .github-svg path,
  .facebook-svg path {
    fill: #fff;
  }
`;

const SocialLogin = () => {
  return (
    <SocialContainer className="social-container">
      <GoogleButton>
        <GoogleLogo />
        Log in with Google
      </GoogleButton>
      <GitButton>
        <GitHubLogo className="github-svg" />
        Log in with GitHub
      </GitButton>
      <FacebookButton>
        <FacebookLogo className="facebook-svg" />
        Log in with Facebook
      </FacebookButton>
    </SocialContainer>
  );
};

export default SocialLogin;