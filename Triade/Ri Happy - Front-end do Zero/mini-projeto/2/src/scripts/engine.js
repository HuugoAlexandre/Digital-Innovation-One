const state = {
  view: {
    squares: document.querySelectorAll(".square"),
    timeLeft: document.querySelector("#time-left"),
    score: document.querySelector("#score"),
    lives: document.querySelector("#lives"),
    recordScore: document.querySelector(".max-score"),
  },
  values: {
    gameVelocity: 1000,
    hitPosition: null,
    result: 0,
    curretTime: 60,
    livesRemaining: 3,
    maxScore: 0,
  },
  actions: {
    timerId: null,
    countDownTimerId: null,
  },
};

function countDown() {
  state.values.curretTime--;
  state.view.timeLeft.textContent = state.values.curretTime;

  if (state.values.curretTime <= 0) {
    clearInterval(state.actions.countDownTimerId);
    clearInterval(state.actions.timerId);
    alert("Game Over! O seu resultado foi: " + state.values.result);
    resetGame();
  }
}

function playSound(audioName) {
  let audio = new Audio(`./src/audios/${audioName}.m4a`);
  audio.volume = 0.2;
  audio.play();
}

function randomSquare() {
  state.view.squares.forEach((square) => {
    square.classList.remove("enemy");
  });

  let randomNumber = Math.floor(Math.random() * state.view.squares.length);
  let randomSquare = state.view.squares[randomNumber];
  randomSquare.classList.add("enemy");
  state.values.hitPosition = randomSquare.id;
}

function newGameFail() {
  alert("Você gastou suas 3 vidas, jogo acabou.");
  clearInterval(state.actions.countDownTimerId);
  clearInterval(state.actions.timerId);
  resetGame();
}

function removeListeners() {
  state.view.squares.forEach((square) => {
    let newSquare = square.cloneNode(true);
    square.replaceWith(newSquare);
  });
  state.view.squares = document.querySelectorAll(".square");
}

function setRecordScore() {
  if (state.values.result > state.values.maxScore) {
    state.view.recordScore.textContent = state.values.result;
    state.values.maxScore = state.values.result;
  }
}

function addListenerHitBox() {
  removeListeners();
  state.view.squares.forEach((square) => {
    square.addEventListener("mousedown", () => {
      if (square.id === state.values.hitPosition) {
        state.values.result++;
        state.view.score.textContent = state.values.result;
        state.values.hitPosition = null;
        playSound("hit");
      } else {
        state.values.livesRemaining--;
        if (state.values.livesRemaining <= 0) {
          newGameFail();
        } else {
          state.view.lives.textContent = state.values.livesRemaining;
        }
      }
    });
  });
}

function resetGame() {
  // Resetar os valores do jogo
  setRecordScore();
  state.values.curretTime = 60;
  state.values.hitPosition = null;
  state.values.result = 0;
  state.values.livesRemaining = 3;
  state.view.timeLeft.textContent = state.values.curretTime;
  state.view.score.textContent = state.values.result;
  state.view.lives.textContent = state.values.livesRemaining;
  initialize();
}

function initialize() {
  addListenerHitBox();

  clearInterval(state.actions.timerId);
  clearInterval(state.actions.countDownTimerId);

  state.actions.timerId = setInterval(randomSquare, state.values.gameVelocity);
  state.actions.countDownTimerId = setInterval(countDown, 1000);
}

initialize();
