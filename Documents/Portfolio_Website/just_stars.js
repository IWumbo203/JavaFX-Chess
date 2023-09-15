const canvas = document.getElementById("canvas");
const c = canvas.getContext("2d");
let w;
let h;
let stars;

const makeStars = count => {
    const out = [];
    for (let i = 0; i < count; i++) {
        const s = {
            x: Math.random() * w - 800,
            y: Math.random() * h - 450,
            z: Math.random() * 1000
        };
        out.push(s);
    }
    return out;
};

const setCanvasExtents = () => {
    const newW = window.innerWidth;
    const newH = window.innerHeight;
    if (w !== newW || h !== newH) {
        w = newW;
        h = newH;
        canvas.width = Math.min(1600, w);
        canvas.height = Math.min(900, h);
        stars = makeStars(2000);
    }
};

setCanvasExtents();

const clear = () => {
    c.fillStyle = "black";
    c.fillRect(0, 0, canvas.width, canvas.height);
};

const putPixel = (x, y, brightness) => {
    const intensity = brightness * 255;
    const rgb = "rgb(" + intensity + "," + intensity + "," + intensity + ")";
    c.fillStyle = rgb;
    c.fillRect(x, y, 1, 1);
};

const moveStars = distance => {
    const count = stars.length;
    for (var i = 0; i < count; i++) {
        const s = stars[i];
        s.z -= distance;
        if (s.z <= 1) {
            s.z += 999;
        }
    }
};

const paintStars = () => {
    clear();
    const cx = canvas.width / 2;
    const cy = canvas.height / 2;

    const count = stars.length;
    for (var i = 0; i < count; i++) {
        const star = stars[i];

        const x = cx + star.x / (star.z * 0.001);
        const y = cy + star.y / (star.z * 0.001);

        if (x < 0 || x >= w || y < 0 || y >= h) {
            continue;
        }

        const d = star.z / 2000.0;
        const b = 1 - d * d;

        putPixel(x, y, b);
    }
};

let prevTime;
const init = time => {
    prevTime = time;
    requestAnimationFrame(tick);
};

const tick = time => {
    let elapsed = time - prevTime;
    prevTime = time;

    moveStars(elapsed * 0.02);

    paintStars();

    requestAnimationFrame(tick);
};

requestAnimationFrame(init);

// Handle window resize
window.addEventListener("resize", () => {
    setCanvasExtents();
});

