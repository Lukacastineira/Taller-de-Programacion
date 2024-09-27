{
   playstation.pas
   
   Copyright 2024 Luka <Luka@DESKTOP-4BOKCJB>
   
   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
   MA 02110-1301, USA.
   
   
}

program   castineira;

type 
    dias = 1..31;  meses = 1..12;
    
    compra = record 
        juego:integer;
        codigo:integer;  // fin codigo 0
        dia:dias;
        mes:meses;
    end;
    
     
    compraB = record 
        juego:integer;
        dia:dias;
        mes:meses;
    end;
       
    
     lista = ^nodo;
    nodo = record
        dato:compraB;
        sig:lista;
     end;
     
    
    arbol = ^nodoA;
    nodoA = record
        codigo:integer;
        list:lista;
        HD:arbol;
        HI:arbol;
    end;
    
    
    vecCompras  = array [meses] of integer; 
    
    procedure leerCompra  (var c:compra);
    begin
         c.codigo := Random (100);
         if (c.codigo <> 0) then
           begin
               c.dia:= Random (31)+1;
               c.mes:=Random(12)+1;
               c.juego:= Random (20000)+1;
           end;
     end;
     
     procedure inicializarV  (var v:vecCompras);
     var i:integer;
     begin
         for i := 1 to 12 do 
         begin 
              v[i]:=0;
         end;
     end;
     
      procedure agregarAdelante  (var l:lista; c:compraB);
      var nue:lista;
      begin
          new(nue); nue^.dato:=c; nue^.sig := l; l:=nue;
      end;
     
     
     procedure ingregarA  (var a:arbol; c:integer; cB:compraB);
     begin
         if ( a = nil ) then
         begin
             new(a); a^.codigo:=c; 
             a^.list:=nil; 
             agregarAdelante(a^.list,cB);
             a^.HI:=nil; a^.HD:=nil;
          end
          else  if  ( c = a^.codigo) then agregarAdelante (a^.list,cB)
          else if (c < a^.codigo) then  ingregarA (a^.HI,c,cB)
          else  ingregarA (a^.HD,c,cB);
      end;
      
        procedure pasarP  (var c:compraB; juego:integer; mes:meses; dia:dias);
      begin
           c.juego:=juego;
           c.mes:= mes;
           c.dia:=dia;
      end;
      
      procedure cargarEstructuras (var a:arbol; var v:vecCompras);
      var    c:compra; cB:compraB;
      begin
             leerCompra (c);
              while (c.codigo <> 0) do
              begin
                     pasarP (cB, c.juego,c.mes,c.dia);
                     ingregarA (a, c.codigo,cB);
                     v[c.mes]:= v[c.mes] + 1;
                     leerCompra (c);
               end;
      end;
      
      
     procedure  incisoB  (a:arbol;  codigo:integer; var l:lista);
      begin
           if (a <> nil ) then
           begin
            if (codigo = a^.codigo) then   l := a^.list
           else if (codigo < a^.codigo) then  incisoB (a^.HI, codigo,l) 
           else  incisoB (a^.HD, codigo,l) ;
           end;
      end;
          
      procedure incisoC  (var v:vecCompras);
      var  i,j,actual:integer;
      begin
           for i:= 2 to 12 do
              begin
                  actual:= v[i];
                  j:= i-1;
                  while  (j>0) and (v[j] > actual) do
                  begin
                       v[j+1] := v[j];
                       j:= j -1;
                  end;
                  v[j + 1]:= actual;
               end;        
      end;    
      
       procedure imprimirL  (l:lista);
      var  aux:lista;
      begin
          aux:=l;
          while  (aux<>nil) do
          begin  
                   writeln (' El  videojuego es: ',aux^.dato.juego);
                   writeln (' El dia de la compra es: ',aux^.dato.dia);
                   writeln (' El mes de la compra es: ',aux^.dato.mes);
                   aux:=aux^.sig;
          end;
     end;
      
      procedure imprimirA  (a:arbol);
      begin
          if (a<>nil) then
             begin
                  imprimirA(a^.HI);
                    writeln('|--------------------------------------------|');
                    writeln (' El codigo de cliente es: ',a^.codigo);
                     writeln('|--------------------------------------------|');
                    imprimirL (a^.list);
                     writeln('|--------------------------------------------|');
                   imprimirA(a^.HD);
              end;
        end;        
      
      procedure   imprimirV (v:vecCompras);
      var i:integer;
      begin
             for i := 1 to 12 do
             begin
                   writeln ('La cantidad de compras realizadas en el mes ' , i , ' es: ', v[i]);
             end;
      end;
      
      
       var   a:arbol; v:vecCompras;  codigo:integer;  lB:lista;
       
       begin
              a:=nil;  lB:=nil;
              inicializarV(v);
              cargarEstructuras(a,v);
              imprimirA(a);
              imprimirV(v);
              writeln (' Ingrese codigo de cliente para saber total de compras realizadas: ');
              readln (codigo);
             incisoB (a,codigo,lB);
              writeln ('El total de compras del cliente de codigo: ', codigo);
              imprimirL(lB);
            if( lB = nil) then writeln ('puto');
             incisoC (v);
             imprimirV(v);
       end.     
           
      
      
      
      
      
      
      
      
      
