#import('dart:math');

num A(i, j) {
  return 1/((i+j)*(i+j+1)/2+i+1);
}

void Au(u, v) {
  for (var i=0; i<u.length; i++) {
    var t = 0;
    for (var j=0; j<u.length; j++)
      t += A(i,j) * u[j];
    v[i] = t;
  }
}

void Atu(u, v) {
  for (var i=0; i<u.length; i++) {
    var t = 0;
    for (var j=0; j<u.length; j++)
      t += A(j,i) * u[j];
    v[i] = t;
  }
}

void AtAu(u, v, w) {
  Au(u,w);
  Atu(w,v);
}

num spectralnorm(n) {
  var i, u=new List(n), v= new List(n), w= new List(n), vv=0, vBv=0;
  for (i=0; i<n; i++) {
    u[i] = 1; v[i] = w[i] = 0;
  }
  for (i=0; i<10; i++) {
    AtAu(u,v,w);
    AtAu(v,u,w);
  }
  for (i=0; i<n; i++) {
    vBv += u[i]*v[i];
    vv  += v[i]*v[i];
  }
  return sqrt(vBv/vv);
}

void main() {
  print(spectralnorm(5500));
}