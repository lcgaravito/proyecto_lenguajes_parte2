 // -----------------------
//    Integrating   a  finitite state transducer with a PDA   to implemet a LEXER-PARSER
// Author:  Silvia Takahashi
// UNIVERSIDAD DE LOS ANDES
// -----------------------
 
 
 
using gold.structures.automaton.*
using gold.visualization.automaton.*

procedure main(args:String[]) begin
    Lexer = createTransducer()
	Parser2 = createAutomaton2()
	Parser = createAutomaton()  //  PDA de tres estados, que implementa diretamente la gramática
   stdin= java.util.Scanner(System.$in)
   print "Desea usar el parser  que implementa directamente la gramatica (1 para SI)"
  var mode:String
  mode := stdin.nextLine()
     
  // GAutomataFrame.show(Lexer)
   
  
  if mode.charAt(0) ='1' then   
     print  "usando el parser que implemeta direcatmente la gramatica"
     GAutomataFrame.show(Parser)
     testParser(Lexer,Parser)
   
   else 
     print  "usando el parser más eficaz"
    
     	GAutomataFrame.show(Parser2)
    
     testParser(Lexer,Parser2)
    end  
    end
    
    
    

procedure testParser(M:ITransducer,P:IPushdownAutomaton) begin
	// M es el  analizador léxico
	// P es el  analizador sintáctico
	var sc:java.util.Scanner(System.$in)
	string="string"
	while string.length()>1 do
		print "----------------------------"
		print "Digite la cadena de entrada: (para termnar la cadena vacia)"
		string:=sc.nextLine()+" "   //Se le agrega un espacio al final para marcar el final de la entrada. El espacio también es un separador.
		result:=M.acceptsString(string)    
		tokenStream := M.getOutputString()
		print "Lexicamente, la cadena fue aceptada "+(result?"aceptada":"rechazada")+". Resultado: "+tokenStream 
	  
	  
		result:=P.acceptsString(tokenStream )  // Al parser se le pasa el token stream
		print "Sintacticamente, la cadena fue "+(result?"aceptada":"rechazada")
		
	end
	print("Termino la ejecucion")
end 

 

function createAutomaton():IPushdownAutomaton begin
	// Este autómata implementa  la  gramática directamente como se  ve en las notas de calse
	//
	//  E -> n
	//  E ->  v
	//  E ->  (+L)
	//  E ->  (*L)
	//  L ->  E
	//  L ->  L E
	
	
	Terms := {'(',')','+','*','v','n'}
	NonTerms := {'E','L'}
	Q:={"I","q","F"}
	Σ:=Terms
	Γ:=Terms ∪ NonTerms ∪ { '$'} 
	q₀:="I"
	F:={"F"}
	M:=GPushdownAutomaton(Q,Σ,Γ,q₀,F)
	
	M.delta("I","q","").push("$E")
	M.delta("q","F","").pop("$")
	
	for each x in {'(',')','+','*','v','n'} do
	  M.delta("q","q",""+x).pop(""+x)
	end
	M.delta("q","q","").changeTop("E","v")
	M.delta("q","q","").changeTop("E","n")
	M.delta("q","q","").changeTop("E",")L+(")
	M.delta("q","q","").changeTop("E",")L*(")
	M.delta("q","q","").changeTop("L","E")
	M.delta("q","q","").changeTop("L","EL")
return M
end

function createAutomaton2():IPushdownAutomaton begin
	
	// En lugar de usar la gramática definimos un autómata con más estados y no tan nodeterminísitico
	//  Con dos estados  El inicial que si lee v o n pasa al final
	//  Si le abrir paréntesis seguido de +.  empila un 1 y vuelva al mismo estado
	//  Si le abrir paréntesis seguido de *.  empila un 1 y vuelva al mismo estado
	// del estado 2 vuelve al estado 1 sin leer nada 
	//  Si en el estado 2   lee un cerrar parenteiss deempila 1
	
	
	
	
	Terms := {'(',')','+','*','v','n'}
	NonTerms := {'E','L'}
	Q:={"I","F"}
	Σ:={'(',')','+','*','v','n'}
	Γ:={'1'}
	q₀:="I"
	F:={"F"}
	M:=GPushdownAutomaton(Q,Σ,Γ,q₀,F)
	
	M.delta("I","I","(+").push("1")
	M.delta("I","I","(*").push("1")
	M.delta("I","F","v").ignore()
	M.delta("I","F","n").ignore()
	M.delta("F","F",")").pop("1")
	M.delta("F","I","").ignore()


return M
end

  
function createTransducer():ITransducer begin
	// Analizador léxico: Recibe una cadena de  letras minúsculas,  dígitos, paréntesis y epacios.
	// genera una cadena de paréntesis, suma,asterostico,ves y enes
	// reconoce las sigueintes palabras reservadas:  plus y times que  traduce en y * resspectivamente
	// los demás nombres  los traduce  a v; las cadenas de digito s  a n.
	
	Q:= {"I","Id", "p", "pl" ,"plu", "plus", "t", "ti" ,"tim", "time", "times", "Num","Err"}
	
	Σ:=('0'‥'9') ∪ ('a' ‥ 'z') ∪ {'(',')',' '} 
	Out:={'(',')','+','*','v','n'} 
	q₀:="I"
	F:= {"I"}
	return 	GDeterministicTransducer(Q,Σ,Out,q₀,F,δ,g,h)
end

function δ(q,σ) begin
	if (q = "Err") then return "Err"
	elseif  σ ∈ {'(',')',' '} then return "I"	
    elseif q="I" and σ='p' then return "p"
	elseif q="I" and σ='t' then return "t"
	elseif q="I" and σ ∈ ('0' ‥ '9') then return "Num"
	elseif	q="Num" and σ ∈ ('0' ‥ '9') then return "Num"
	elseif	q="Num" and σ ∈ ('a' ‥ 'z') then return "Err"
	elseif q="p" and σ='l' then return "pl" 
    elseif q="pl" and σ='u' then return "plu" 
    elseif q="plu" and σ='s' then return "plus" 
	elseif q="t" and σ='i' then return "ti" 
    elseif q="ti" and σ='m' then return "tim" 
    elseif q="tim" and σ='e' then return "time" 
    elseif q="time" and σ='s' then return "times" 
    else  return "Id"
    end	
end 



function g(q) begin
	return λ
end

function h(q,σ) begin
var s: String
s := λ

if q ∉ {"Err"} and σ ∈ {'(',')',' '} then

		if σ ∉ {' '} then  s=String.valueOf(σ) end

      if q=="I" then return s
      elseif q=="plus" then return "+"+s 
      elseif q=="times" then return "*"+s
      elseif q=="Num" then return "n"+s
      else return "v"+s
      end
else return  λ

end
end