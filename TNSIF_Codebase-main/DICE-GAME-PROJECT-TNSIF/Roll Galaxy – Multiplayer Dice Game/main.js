let players = [];
let currentPlayerIndex = 0;
let winningScore = 50;
let currentRound = 1;
let isRolling = false;

const diceRotations = {
    1: {
        x: 0,
        y: 0,
        z: 0
    },
    2: {
        x: 0,
        y: -90,
        z: 0
    },
    3: {
        x: -90,
        y: 0,
        z: 0
    },
    4: {
        x: 90,
        y: 0,
        z: 0
    },
    5: {
        x: 0,
        y: 90,
        z: 0
    },
    6: {
        x: 0,
        y: 180,
        z: 0
    }
};

function generatePlayerInputs() {
    const playerCount = parseInt(document.getElementById('playerCount').value);
    const container = document.getElementById('playerNames');
    container.innerHTML = '';

    for (let i = 1; i <= playerCount; i++) {
        const div = document.createElement('div');
        div.className = 'form-group';
        div.innerHTML = `
            <label for="player${i}">Player ${i} Name</label>
            <div class="input-group">
                <input type="text" id="player${i}" placeholder="Enter player ${i} name" value="Player ${i}">
            </div>
        `;
        container.appendChild(div);
    }
}

function startGame() {
    const playerCount = parseInt(document.getElementById('playerCount').value);
    winningScore = parseInt(document.getElementById('winningScore').value);

    if (winningScore < 10 || winningScore > 100) {
        alert('Please enter a winning score between 10 and 100');
        return;
    }

    players = [];
    for (let i = 1; i <= playerCount; i++) {
        const name = document.getElementById(`player${i}`).value.trim() || `Player ${i}`;
        players.push({
            name,
            score: 0
        });
    }

    currentPlayerIndex = 0;
    currentRound = 1;

    document.getElementById('setupScreen').style.display = 'none';
    document.getElementById('gameScreen').style.display = 'block';
    document.getElementById('targetScore').textContent = winningScore;

    updateDisplay();
    showDiceFace(1);
}

function updateDisplay() {
    const currentPlayer = players[currentPlayerIndex];
    document.getElementById('currentPlayerName').textContent = currentPlayer.name;
    document.getElementById('currentPlayerScore').textContent = `Score: ${currentPlayer.score}`;
    document.getElementById('currentRound').textContent = currentRound;

    updateLeaderboard();
}

function updateLeaderboard() {
    const playerList = document.getElementById('playerList');
    playerList.innerHTML = '';

    const sortedPlayers = [...players].sort((a, b) => b.score - a.score);

    sortedPlayers.forEach((player, index) => {
        const playerItem = document.createElement('div');
        playerItem.className = 'player-item';

        if (player.name === players[currentPlayerIndex].name) {
            playerItem.classList.add('active');
        }

        if (player.score >= winningScore) {
            playerItem.classList.add('winner');
        }

        playerItem.innerHTML = `
            <div class="player-name-item">${index + 1}. ${player.name}</div>
            <div class="player-score-item">${player.score}</div>
        `;

        playerList.appendChild(playerItem);
    });
}

function showDiceFace(number) {
    const dice = document.getElementById('dice3d');
    const rotation = diceRotations[number];
    dice.style.transform = `rotateX(${rotation.x}deg) rotateY(${rotation.y}deg) rotateZ(${rotation.z}deg)`;
}

function rollDice() {
    if (isRolling) return;

    isRolling = true;
    const dice = document.getElementById('dice3d');
    const rollBtn = document.getElementById('rollBtn');

    dice.classList.add('rolling');
    rollBtn.disabled = true;
    rollBtn.textContent = '🎲 Rolling...';

    setTimeout(() => {
        const finalRoll = Math.floor(Math.random() * 6) + 1;
        dice.classList.remove('rolling');

        // Add extra rotations for more dramatic effect
        const extraRotations = Math.floor(Math.random() * 3) + 1;
        const rotation = diceRotations[finalRoll];
        dice.style.transform = `rotateX(${rotation.x + (360 * extraRotations)}deg) rotateY(${rotation.y + (360 * extraRotations)}deg) rotateZ(${rotation.z}deg)`;

        players[currentPlayerIndex].score += finalRoll;

        checkWinner();

        setTimeout(() => {
            nextPlayer();
            isRolling = false;
            rollBtn.disabled = false;
            rollBtn.textContent = '🎲 Roll Dice';
        }, 800);
    }, 1200);
}

function checkWinner() {
    const currentPlayer = players[currentPlayerIndex];
    if (currentPlayer.score >= winningScore) {
        setTimeout(() => {
            document.getElementById('winnerName').textContent = `${currentPlayer.name} Wins!`;
            document.getElementById('finalScore').textContent = `Final Score: ${currentPlayer.score} points`;
            document.getElementById('gameOver').style.display = 'flex';
        }, 1000);
        return true;
    }
    return false;
}

function nextPlayer() {
    currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    if (currentPlayerIndex === 0) {
        currentRound++;
    }
    updateDisplay();
}

function newGame() {
    document.getElementById('gameOver').style.display = 'none';
    document.getElementById('gameScreen').style.display = 'none';
    document.getElementById('setupScreen').style.display = 'block';

    players = [];
    currentPlayerIndex = 0;
    currentRound = 1;
    isRolling = false;

    showDiceFace(1);
}

// Initialize player inputs on page load
document.addEventListener('DOMContentLoaded', function() {
    generatePlayerInputs();
    document.getElementById('playerCount').addEventListener('change', generatePlayerInputs);
});