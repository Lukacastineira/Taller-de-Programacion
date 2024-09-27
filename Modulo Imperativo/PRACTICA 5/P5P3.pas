{
3. Un supermercado requiere el procesamiento de sus productos. De cada producto se
conoce código, rubro (1..10), stock y precio unitario. Se pide:

a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su
vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo
más eficiente posible. El ingreso finaliza con el código de producto igual a 0.

b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.

c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada
rubro, el código y stock del producto con mayor código.

d) Implementar un módulo que reciba la estructura generada en a), dos códigos y
retorne, para cada rubro, la cantidad de productos con códigos entre los dos valores
ingresados.

}

program  P5P3;


TYPE
      rangoRubro =  1..10;
      
      producto = record
            codigo:integer;
            rubro:rangoRubro;
            stock:integer;
            precioU:real;
      end;
      
      productoA = record
           codigo:integer;
           stock:integer;
           precioU:real;
      end;
      
      arbol = ^nodo;
      nodo = record
          dato : productoA;
          HI:arbol;
          HD:arbol;
      end;
      
      vecRubro = array [rangoRubro] of arbol;
      
      producmax= record
           codigo:integer;
           stock:integer;
      end;
    
      vecMaximos = array [rangoRubro] of producmax;
      
      vecEntre = array [rangoRubro] of integer;
      
procedure  inicializarV  (var v:vecRubro);   
var i:integer;   
begin
      for  i:= 1 to  10 do
      begin
             v[i]:= nil;
      end;
end;      
      
      
  Procedure CargarP (var p: producto);
  begin
    writeln (' Ingrese codigo de Producto: ');
    readln(p.codigo);
    If (p.codigo <> 0) then 
     begin
          writeln ('Ingrese Rubro: ');
          readln(p.rubro);
          p.stock:= random (99-1)+1;
          p.precioU:= random(5000-100)+100;
         end;
  end;  
  
  Procedure   insertarAP   (var a:arbol; p:productoA);
  begin
      if(a=nil) then
      begin
            new(a); a^.dato:=p; a^.HI:=nil; a^.HD:=nil;
      end
      else if (p.codigo < a^.dato.codigo) then  insertarAP(a^.HI,p)
      else insertarAP(a^.HD,p)
end;


procedure   pasarP  (var pA:productoA;  codigo:integer; stock:integer; precio:real);
begin
      pA.codigo:= codigo;
      pA.stock:= stock;
      pA.precioU:= precio;
end;


procedure   CargarVector    (var v:vecRubro; var a:arbol) ;
var       p:producto;   pA:productoA; 
begin
          CargarP (p); 
          while  (p.codigo <> 0) do                                                                                           ////       A)------------------------------------------------
          begin
                  pasarP(pA, p.codigo,p.stock,p.precioU);
                  insertarAP (v[p.rubro], pA);
                  CargarP(p);
          end;
end;                


procedure   imprimirA  (a:arbol);
begin
      if  (a<>nil) then
          begin
               imprimirA(a^.HI);
                  writeln ('\------------------------------------------------------------\');
                  writeln ('El codigo del producto es: ', a^.dato.codigo);
                  writeln ('El stock del producto es: ', a^.dato.stock);
                  writeln ('El precio del producto es: ', a^.dato.precioU:0:2);       
                  writeln ('\------------------------------------------------------------\');          
               imprimirA(a^.HD);
          end;
end;

          
procedure   imprimirV  (v:vecRubro);
var    i:integer;
begin
         for  i:= 1 to 10 do
         begin
               if (v[i] = nil) then 
               begin
                  writeln ('|---------------------------------------------|');
                  writeln ('El rubro: ', i, ' no tiene productos. ');
                  writeln ('|---------------------------------------------|');
               end
               else
               begin
               writeln ('|---------------------------------------------|');
               writeln ('Los productos del rubro: ', i, ' son: ');
               writeln ('|---------------------------------------------|');
               imprimirA(v[i]);
               end;
         end;        
end;

function   buscarArbol   (a:arbol; codigo:integer) : boolean;
begin
      if (a=nil) then  buscarArbol := false
      else if ( codigo = a^.dato.codigo) then   buscarArbol:= true
      else if (codigo < a^.dato.codigo) then  buscarArbol:= buscarArbol(a^.HI,codigo)           ////////   B)-----------------------------------------
      else   buscarArbol:= buscarArbol(a^.HD,codigo);
end;


procedure  maximo   (a:arbol; var maxCod,maxStock:integer );
begin
      if (a= nil) then 
      begin
            maxCod:= 0;   maxStock:= 0;
      end
      else if (a^.HD = nil) then 
      begin
           maxCod:= a^.dato.codigo; maxStock:= a^.dato.stock;
      end
      else  maximo(a^.HD,maxCod,maxStock);
end;

procedure  maximos  (v:vecRubro;   var vM:vecMaximos) ;
var   maxC,maxS:integer;  i:integer;
begin
      maxC:=0; maxS:=0;
      for i:= 1 to 10 do
      begin 
             maximo (v[i], maxC,maxS);                                                                                     ////////     C)--------------------------------------------
             if (v[i] = nil) then 
             begin
                 vM[i].codigo:=0;
                 vM[i].stock:=0;
             end
             else       
                 vM[i].codigo:=maxC;
                 vM[i].stock:=maxS;
      end;          
end;            

function   contP  (a:arbol;  cod1,cod2:integer) : integer;
begin
      if(a=nil) then   contP:= 0
      else  if (cod1 < a^.dato.codigo) and (cod2 > a^.dato.codigo) then   contP:= 1 + contP (a^.HI, cod1,cod2) + contP (a^.HD, cod1,cod2)
      else  if (cod1 >= a^.dato.codigo) then   contP:=contP (a^.HD, cod1,cod2)
      else  contP:=contP (a^.HI, cod1,cod2);
end;
       
       
procedure  entreCod  (v:vecRubro;   var vE:vecEntre;  cod1,cod2:integer) ;
var    contador:integer; i:integer;
begin
     contador:=0;
      for i:= 1 to 10 do
      begin                                                                                           
             if (v[i] = nil) then 
                  vE[I]:= 0
             else      
             begin
                 contador:= contP(v[i],cod1,cod2);    
                 vE[i]:=contador;
             end;
      end;          
end;   

procedure     imprimirMaxi  (v:vecMaximos);
var   i:integer;
begin  
    for i:= 1 to 10  do
    begin  
         if (v[i].codigo = 0) then  writeln (' El rubro ', i, ' esta vacio.')
         else
         writeln  (' El codigo maximo del rubro: ', i,  ' es: ', v[i].codigo   , ' y, su stock es: ',  v[i].stock);
    end;
end;

procedure     imprimirEntre  (v:vecEntre; cod1,cod2:integer);
var   i:integer;
begin  
    for i:= 1 to 10  do
    begin  
         if (v[i] = 0) then  writeln (' No se econtraron codigos entre: ', cod1, ' y ', cod2,  ' del vector ', i )
         else
         writeln  (' El total de codigos entre: ', cod1,  ' y  ', cod2 , ' del vector ', i ,'  es: ',  v[i]);
    end;
end;
            
var   a:arbol;   v:vecRubro;    rubroB :rangoRubro;   codigo:integer;   encontre:boolean;  vM:vecMaximos;  cod1,cod2:integer; vE:vecEntre;

begin
      randomize;
      a:=nil;
      inicializarV(v);
      CargarVector(v,a);
      imprimirV (v);
      writeln (' Ingrese Rubro: ');
      readln(rubroB);
      writeln(' Ingrese codigo: ');
      readln(codigo);
      encontre := buscarArbol(v[rubroB], codigo);
      if ( not encontre) then writeln (' El codigo ' ,codigo, ' no se encontro, en el rubro ', rubroB)
      else writeln ('El codigo ', codigo, ' esta en el rubro ', rubroB);
      maximos (v,vM);
      imprimirMaxi(vM);
       writeln (' Ingrese codigo 1: ');
      readln(cod1);
      writeln(' Ingrese codigo 2 (mayor a codigo 1): ');
      readln(cod2);
      entreCod(v,vE,cod1,cod2);
      imprimirEntre(vE,cod1,cod2);
end.      
