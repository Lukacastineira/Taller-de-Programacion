{a) Implemente un módulo CargarVector que cree un vector de enteros
con a lo sumo 50 valores aleatorios. Los valores, generados
aleatoriamente (entre un mínimo y máximo recibidos por parámetro),
deben ser almacenados en el vector en el mismo orden que se
generaron, hasta que se genere el cero.}

program vectores;
const   
  dimF=50;
type 
  rangoDim=1..50;
  vector= array  [1..50] of integer; 
 
procedure generar_V (a,b:integer; var v:vector; var dimL:integer);     
var  aleatorio :integer;                         
begin 
    dimL:=0;
    randomize;  
    aleatorio:= random(b-a)+a; 
    while (aleatorio<>0) do
    begin   
       dimL:= dimL + 1;     
       writeln ('El numero aleatorio generado es: ', aleatorio);       
       V[dimL]:= aleatorio;
       aleatorio:= random(b-a)+a;  
       readln();                                            
     end;
 END;    
procedure imprimir_V (v:vector; dimL:integer);
VAR  i:integer;
begin                                                                    //b) Implemente un módulo ImprimirVector que reciba el vector generago en 
     for i:= dimL downto 1 do  
      begin                                                   //a) e imprima todos los valores del vector en el mismo orden que están almacenados.       
        writeln (v[i]);                                    //Qué cambiaría para imprimir en orden inverso rta: se pone downto en vez de to.
      end;
end;                                                                     
var  v:vector; dimL,a,b:integer;                           
begin
   writeln('ingrese extrenmo inferior: ');
   readln (a);
   writeln('ingrese extremo superior: ');
   readln (b);
   generar_V(a,b,v,dimL); 
   imprimir_V(v,dimL)

end.                            

  

