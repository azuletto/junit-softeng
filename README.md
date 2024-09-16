[![Typing SVG](https://readme-typing-svg.demolab.com?font=Comfortaa&size=30&duration=2000&pause=1000&color=755683&background=57575700&random=true&width=435&lines=Unit+tests+example's.;With+JUnit.)](https://git.io/typing-svg)


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animated Bouncing Ball</title>
    <style>
        body {
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #282c34;
            overflow: hidden;
        }

        canvas {
            border: 2px solid white;
            background-color: #1c1c1c;
        }

        h1 {
            position: absolute;
            top: 10%;
            text-align: center;
            width: 100%;
            color: white;
            font-family: Arial, sans-serif;
        }
    </style>
</head>
<body>

    <h1>Cool Bouncing Ball Animation</h1>
    <canvas id="animationCanvas"></canvas>

    <script>
        const canvas = document.getElementById('animationCanvas');
        const ctx = canvas.getContext('2d');

        // Set canvas dimensions
        canvas.width = window.innerWidth * 0.8;
        canvas.height = window.innerHeight * 0.6;

        // Ball properties
        let ball = {
            x: canvas.width / 2,
            y: canvas.height / 2,
            radius: 30,
            dx: 4,
            dy: 4,
            color: 'lightblue'
        };

        // Animate the ball
        function drawBall() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            ctx.beginPath();
            ctx.arc(ball.x, ball.y, ball.radius, 0, Math.PI * 2);
            ctx.fillStyle = ball.color;
            ctx.fill();
            ctx.closePath();
        }

        function updateBallPosition() {
            ball.x += ball.dx;
            ball.y += ball.dy;

            // Bounce off the walls
            if (ball.x + ball.radius > canvas.width || ball.x - ball.radius < 0) {
                ball.dx *= -1;
            }

            if (ball.y + ball.radius > canvas.height || ball.y - ball.radius < 0) {
                ball.dy *= -1;
            }
        }

        function animate() {
            drawBall();
            updateBallPosition();
            requestAnimationFrame(animate);
        }

        animate();
    </script>
</body>
