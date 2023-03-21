
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/** sketch_230321a */
public class sketch_230321a {
let angle = 0;
let cubes = [];

function setup() {
  createCanvas(600, 400, WEBGL);
  noStroke();
  for (let i = 0; i < 20; i++) {
    cubes.push(new Cube(random(-200, 200), random(-200, 200), random(-200, 200)));
  }
}

function draw() {
  background(0);
  angle += 0.01;
  
  // Draw rotating cubes
  push();
  rotateX(angle);
  rotateY(angle*1.2);
  for (let i = 0; i < cubes.length; i++) {
    cubes[i].display();
    cubes[i].move();
  }
  pop();
  
  // Draw static spheres
  push();
  fill(255, 0, 0, 100);
  translate(-100, 0, 0);
  sphere(50);
  pop();
  
  push();
  fill(255, 255, 255, 100);
  translate(100, 0, 0);
  sphere(50);
  pop();
}

class Cube {
  constructor(x, y, z) {
    this.pos = createVector(x, y, z);
    this.vel = createVector(random(-1, 1), random(-1, 1), random(-1, 1));
    this.size = random(20, 50);
    this.int = color(random(255), 0, 0);
  }
  
  display() {
    push();
    fill(this.int );
    translate(this.pos.x, this.pos.y, this.pos.z);
    box(this.size);
    pop();
  }
  
  move() {
    this.pos.add(this.vel);
    if (this.pos.x > 200 || this.pos.x < -200) {
      this.vel.x *= -1;
    }
    if (this.pos.y > 200 || this.pos.y < -200) {
      this.vel.y *= -1;
    }
    if (this.pos.z > 200 || this.pos.z < -200) {
      this.vel.z *= -1;
    }
  }
}
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- PLEASE NO CHANGES BELOW THIS LINE (UNTIL I SAY SO) -->
  <script language="javascript" type="text/javascript" src="libraries/p5.min.js"></script>
  <script language="javascript" type="text/javascript" src="sketch_230321a.js"></script>
  <!-- OK, YOU CAN MAKE CHANGES BELOW THIS LINE AGAIN -->

  <style>
    body {
      padding: 0;
      margin: 0;
    }
  </style>
</head>

<body>
</body>
</html>
}

