program ProgramaAleatorio;



procedure Num_Aleatorio ( aleatorio:integer);
begin
       randomize;                        {Elige una semilla distinta cada vez que se ejecuta el programa.}
                                         {La semilla sirve para generar series de números aleatorios distintos.}
                                         {Sin la llamada al procedimiento randomize, en todas las ejecuciones
                                          del programa se elige siempre la misma serie de números aleatorios.}
     aleatorio := random (100); {devuelve un valor aleatorio en el intervalo 0 a 99}   
     writeln ('El numero aleatorio generado es: ', aleatorio);
	 writeln ('Presione cualquier tecla para finalizar');                               // A) Responda ¿Qué hace el programa?    Rta: El programa genera un numero aletario entre 0 y 99;
     readln;
end;

procedure Veinte_Numaleatorio;                                      // c) Modifique el programa para que imprima 20 números aleatorios.
var i:integer; aleatorio:integer;
begin
    i:=1;
       randomize;   
    for i := 1 to 20 do 
    begin
       aleatorio:= random(100);
       writeln ('El numero aleatorio generado es: ', aleatorio);  
    end;
	writeln ('Presione cualquier tecla para finalizar');                              
    readln;
end;

procedure N_Numaleatorio2 (a,b,total:integer);                                    
var i:integer; aleatorio:integer;
begin
    i:=1;
    randomize;   
    for i := 1 to total do 
    begin                                                //d) Modifique el programa para que imprima N números aleatorios en el rango (A,B), donde N, A y B son números enteros que se leen por teclado.
        aleatorio:= random(b-a)+ a; 
       writeln ('El numero aleatorio generado es: ', aleatorio);  
    end;
	writeln ('Presione cualquier tecla para finalizar');                              
    readln;
end;

procedure Num_Hasta (a,b,fin:integer);     
var  aleatorio :integer;                               
begin
    randomize;   
    aleatorio:= random(b-a)+ a; 
    while (aleatorio<>fin) do
    begin        
       writeln ('El numero aleatorio generado es: ', aleatorio);         //e) Modifique el programa para que imprima números aleatorios en el rango (A,B) hasta que se genere un
       aleatorio:= random(b-a)+ a; 
       readln();                                              //valor igual a F, el cual no debe imprimirse. F, A y B son números enteros que se leen por teclado.      
     end;
	writeln ('Presione cualquier tecla para finalizar');                              
    readln;
end;                              
var
  a,b,fin:integer; 
begin
   writeln('ingrese el numero entero que da el fin de la impresion: ');            
   readln(fin);
   writeln('ingrese extrenmo inferior: ');
   readln (a);
   writeln('ingrese extremo superior: ');
   readln (b);
   Num_Hasta(a,b,fin); 
end.
