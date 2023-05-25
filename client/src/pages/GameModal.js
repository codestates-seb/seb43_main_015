import React, { useState, useEffect } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';
import styled from 'styled-components';

import 'bootstrap/dist/css/bootstrap.min.css';

const GameModalContents = styled.div`
  display: flex;
  /* align-items: flex-start; */
`;

const GameModalItems = styled.div`
  margin-left: 20px;
  p {
    margin-bottom: 22px;
  }
`

const LikeButton = styled.button`
  /* background-color: red; */
  /* float: right; */
  margin-left: auto;
  height: 24px;
  border: none;
  background-color: #fff;
  
`;

const Explanation = styled.div`
  margin-top: 20px;
`;

const StyledFormGroup = styled(Form.Group)`
  margin: 20px 0 80px 0;
`;

const CustomButton = styled.button`
  margin-top: 20px;
  float: right;
`;

const Textarea = styled.div`
  border-top: 1px solid #dee2e6;
  padding-top: 20px;
`;

const CommentArea = styled.div`
  border: 1px solid #dee2e6;
  margin-top: 1px;
  padding-top: 20px;
`;

const GameModal = ({ show, onHide, game, comment, onCommentChange, onCommentSubmit }) => {
  const [changed, setChanged] = useState(false);  

  return (
    <Modal
      show={show}
      onHide={onHide}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
          {game ? game.title : ''}
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {game && (
          <>
            <GameModalContents>
              <div>
                <img src={game.imageUrl} alt='게임 이미지'/>
              </div>
              <GameModalItems>
                <p>게임 제목: {game.title}</p>
                <p>플랫폼: {game.platform}</p>
                <p>장르: {game.genre}</p>
                <p>제작사: {game.producer}</p>
                <p>제공사: {game.provider}</p>
                <p>등급: {game.level}</p>
                <p>출시일: {game.year}</p>
              </GameModalItems>
              <LikeButton onClick={(e) => {
                setChanged(!changed);
              }}>
              {changed ? '♥' : '♡'}
              </LikeButton>
            </GameModalContents>
            <Explanation><h3>소개</h3> {game.explanation}</Explanation>
          </>
        )}
        <StyledFormGroup>
          <Form.Label>평가</Form.Label>
          <Form.Control
            type="text"
            value={comment}
            onChange={onCommentChange}
          />
          {/* as를 이용해 Button 컴포넌트에 추가적인 속성을 지정 */}
          <Button onClick={onCommentSubmit} as={CustomButton}>제출</Button>
        </StyledFormGroup>
        <Textarea>
          <h3>댓글</h3>
          {game && game.comments && game.comments.map((comment, id) => (
            <CommentArea key={id}>
              <p>{comment.text}</p>
              <p>{comment.date}</p>
            </CommentArea>
          ))}
        
        </Textarea>
      </Modal.Body>
      <Modal.Footer>
        <Button onClick={onHide}>닫기</Button>
      </Modal.Footer>
    </Modal>
  );
};

export default GameModal;
