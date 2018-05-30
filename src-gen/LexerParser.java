// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/LexerParser.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class LexerParser {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=13;
      Object Lexer=$fix(LexerParser.createTransducer());
      $line=14;
      Object Parser2=$fix(LexerParser.createAutomaton2());
      $line=15;
      Object Parser=$fix(LexerParser.createAutomaton());
      $line=16;
      Object stdin=$fix($invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)}));
      $line=17;
      System.out.println($message(new Object[]{"Desea usar el parser  que implementa directamente la gramatica (1 para SI)"}));
      $line=18;
      String mode=null;
      mode=$defaultValue(String.class);
      $line=19;
      mode=$cast(String.class,$fix(((java.util.Scanner)stdin).nextLine()));
      $line=24;
      if ($opEqualY(((java.lang.String)mode).charAt($int(0)),'1')) {
        $line=25;
        System.out.println($message(new Object[]{"usando el parser que implemeta direcatmente la gramatica"}));
        $line=26;
        GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,Lexer));
      }
      else {
        $line=31;
        System.out.println($message(new Object[]{"usando el parser m\u00E1s eficaz"}));
        $line=33;
        GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,Lexer));
      }
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"main",$line);
    }
  }
  public static Object testParser(ITransducer M, IPushdownAutomaton P) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=46;
      java.util.Scanner sc=null;
      sc=$invokeConstructor(java.util.Scanner.class,new Object[]{$invokeField(System.class,"in",true,null)});
      $line=47;
      Object string=$fix("string");
      $line=48;
      while (true) {
        if (!($opGreatY($invokeMethod("length",string,new Object[]{}),1))) break;
        $line=49;
        System.out.println($message(new Object[]{"----------------------------"}));
        $line=50;
        System.out.println($message(new Object[]{"Digite la cadena de entrada: (para termnar la cadena vacia)"}));
        $line=51;
        string=$fix($opAdditY(((java.util.Scanner)sc).nextLine()," "));
        $line=52;
        Object result=$fix(((gold.structures.automaton.ITransducer)M).acceptsString($cast(java.lang.String.class,string)));
        $line=53;
        Object tokenStream=$fix(((gold.structures.automaton.ITransducer)M).getOutputString());
        $line=54;
        System.out.println($message(new Object[]{$opAdditY($opAdditY($opAdditY("Lexicamente, la cadena fue aceptada ",(($bool(result))?("aceptada"):("rechazada"))),". Resultado: "),tokenStream)}));
        $line=57;
        result=$fix(((gold.structures.automaton.IPushdownAutomaton)P).acceptsString($cast(java.lang.String.class,tokenStream)));
        $line=58;
        System.out.println($message(new Object[]{$opAdditY("Sintacticamente, la cadena fue ",(($bool(result))?("aceptada"):("rechazada")))}));
      }
      $line=61;
      System.out.println($message(new Object[]{"Termino la ejecucion"}));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"testParser",$line);
    }
    return $result;
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=77;
      Object Terms=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=78;
      Object NonTerms=$fix(GCollections.asSet('E','L'));
      $line=79;
      Object Q=$fix(GCollections.asSet("I","q","F"));
      $line=80;
      Object \u03A3=$fix(Terms);
      $line=81;
      Object \u0393=$fix($opUnionY($opUnionY(Terms,NonTerms),GCollections.asSet('$')));
      $line=82;
      Object q_0=$fix("I");
      $line=83;
      Object F=$fix(GCollections.asSet("F"));
      $line=84;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=86;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","q",$cast(java.lang.String.class,"")),new Object[]{"$E"});
      $line=87;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","F",$cast(java.lang.String.class,"")),new Object[]{"$"});
      $line=89;
      for (Object $v1:GCollections.unmodifiableCollection(GCollections.asSet('(',')','+','*','v','n'))) {
        Object x=$v1;
        $line=90;
        $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,$opAdditY("",x))),new Object[]{$opAdditY("",x)});
      }
      $line=92;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E","v"});
      $line=93;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E","n"});
      $line=94;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E",")L+("});
      $line=95;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"E",")L*("});
      $line=96;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"L","E"});
      $line=97;
      $invokeMethod("changeTop",((gold.structures.automaton.GPushdownAutomaton)M).delta("q","q",$cast(java.lang.String.class,"")),new Object[]{"L","EL"});
      $line=98;
      $result=M;
      if (true) break $try;
      $line=99;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
  public static IPushdownAutomaton createAutomaton2() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=113;
      Object Terms=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=114;
      Object NonTerms=$fix(GCollections.asSet('E','L'));
      $line=115;
      Object Q=$fix(GCollections.asSet("I","F"));
      $line=116;
      Object \u03A3=$fix(GCollections.asSet('(',')','+','*','v','n'));
      $line=117;
      Object \u0393=$fix(GCollections.asSet('1'));
      $line=118;
      Object q_0=$fix("I");
      $line=119;
      Object F=$fix(GCollections.asSet("F"));
      $line=120;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=122;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"(+")),new Object[]{"1"});
      $line=123;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","I",$cast(java.lang.String.class,"(*")),new Object[]{"1"});
      $line=124;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","F",$cast(java.lang.String.class,"v")),new Object[]{});
      $line=125;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("I","F",$cast(java.lang.String.class,"n")),new Object[]{});
      $line=126;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta("F","F",$cast(java.lang.String.class,")")),new Object[]{"1"});
      $line=127;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta("F","I",$cast(java.lang.String.class,"")),new Object[]{});
      $line=130;
      $result=M;
      if (true) break $try;
      $line=131;
      $rethrow(new RuntimeException("The function \"createAutomaton2()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"createAutomaton2",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
  public static ITransducer createTransducer() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=140;
      Object Q=$fix(GCollections.asSet("I","Id","p","p_","p_r","p_re","p_red","f","fi","fin","fin_","fin_r","fin_re","fin_red","Nom","Err"));
      $line=142;
      Object \u03A3=$fix($opUnionY($opIntvlY('a','z'),GCollections.asSet('_',' ')));
      $line=143;
      Object Out=$fix(GCollections.asSet('P','n','F'));
      $line=144;
      Object q_0=$fix("I");
      $line=145;
      Object F=$fix(GCollections.asSet("I"));
      $line=146;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,\u03A3,Out,q_0,F,new GMethod(LexerParser.class,"\u03B4"),new GMethod(LexerParser.class,"g"),new GMethod(LexerParser.class,"h")});
      if (true) break $try;
      $line=147;
      $rethrow(new RuntimeException("The function \"createTransducer()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"createTransducer",$line);
    }
    return $cast(ITransducer.class,$result);
  }
  public static Object \u03B4(Object q, Object \u03C3) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=150;
      if ($bool($opEqualY(q,"Err"))) {
        $line=150;
        $result="Err";
        if (true) break $try;
      }
      else {
        $line=151;
        if ($opMembrY(\u03C3,GCollections.asSet(' '))) {
          $line=151;
          $result="I";
          if (true) break $try;
        }
        else {
          $line=152;
          if (($opEqualY(q,"I")&&$opEqualY(\u03C3,'p'))) {
            $line=152;
            $result="p";
            if (true) break $try;
          }
          else {
            $line=153;
            if (($opEqualY(q,"p")&&$opEqualY(\u03C3,'_'))) {
              $line=153;
              $result="p_";
              if (true) break $try;
            }
            else {
              $line=154;
              if (($opEqualY(q,"p_")&&$opEqualY(\u03C3,'r'))) {
                $line=154;
                $result="p_r";
                if (true) break $try;
              }
              else {
                $line=155;
                if (($opEqualY(q,"p_r")&&$opEqualY(\u03C3,'e'))) {
                  $line=155;
                  $result="p_re";
                  if (true) break $try;
                }
                else {
                  $line=156;
                  if (($opEqualY(q,"p_re")&&$opEqualY(\u03C3,'d'))) {
                    $line=156;
                    $result="p_red";
                    if (true) break $try;
                  }
                  else {
                    $line=158;
                    if (($opEqualY(q,"I")&&$opEqualY(\u03C3,'f'))) {
                      $line=158;
                      $result="f";
                      if (true) break $try;
                    }
                    else {
                      $line=159;
                      if (($opEqualY(q,"f")&&$opEqualY(\u03C3,'i'))) {
                        $line=159;
                        $result="fi";
                        if (true) break $try;
                      }
                      else {
                        $line=160;
                        if (($opEqualY(q,"fi")&&$opEqualY(\u03C3,'n'))) {
                          $line=160;
                          $result="fin";
                          if (true) break $try;
                        }
                        else {
                          $line=161;
                          if (($opEqualY(q,"fin")&&$opEqualY(\u03C3,'_'))) {
                            $line=161;
                            $result="fin_";
                            if (true) break $try;
                          }
                          else {
                            $line=162;
                            if (($opEqualY(q,"fin_")&&$opEqualY(\u03C3,'r'))) {
                              $line=162;
                              $result="fin_r";
                              if (true) break $try;
                            }
                            else {
                              $line=163;
                              if (($opEqualY(q,"fin_r")&&$opEqualY(\u03C3,'e'))) {
                                $line=163;
                                $result="fin_re";
                                if (true) break $try;
                              }
                              else {
                                $line=164;
                                if (($opEqualY(q,"fin_re")&&$opEqualY(\u03C3,'d'))) {
                                  $line=164;
                                  $result="fin_red";
                                  if (true) break $try;
                                }
                                else {
                                  $line=166;
                                  if (($opEqualY(q,"I")&&$opMembrY(\u03C3,$opIntvlY('a','z')))) {
                                    $line=166;
                                    $result="Nom";
                                    if (true) break $try;
                                  }
                                  else {
                                    $line=167;
                                    if (($opEqualY(q,"Nom")&&$opMembrY(\u03C3,$opIntvlY('a','z')))) {
                                      $line=167;
                                      $result="Nom";
                                      if (true) break $try;
                                    }
                                    else {
                                      $line=169;
                                      if (($opEqualY(q,"Num")&&$opMembrY(\u03C3,$opIntvlY('a','z')))) {
                                        $line=169;
                                        $result="Err";
                                        if (true) break $try;
                                      }
                                      else {
                                        $line=172;
                                        $result="Id";
                                        if (true) break $try;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=174;
      $rethrow(new RuntimeException("The function \"\u03B4(q:Object,\u03C3:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"\u03B4",$line);
    }
    return $result;
  }
  public static Object g(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=179;
      $result="";
      if (true) break $try;
      $line=180;
      $rethrow(new RuntimeException("The function \"g(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"g",$line);
    }
    return $result;
  }
  public static Object h(Object q, Object \u03C3) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=183;
      String s=null;
      s=$defaultValue(String.class);
      $line=184;
      s=$cast(String.class,$fix(""));
      $line=186;
      if ((!$opMembrY(q,GCollections.asSet("Err"))&&$opMembrY(\u03C3,GCollections.asSet(' ')))) {
        $line=188;
        if (!$opMembrY(\u03C3,GCollections.asSet(' '))) {
          $line=188;
          s=$cast(String.class,$fix($invokeMethod(String.class,"valueOf",true,null,new Object[]{\u03C3})));
        }
        $line=190;
        if ($opEqualY(q,"I")) {
          $line=190;
          $result=s;
          if (true) break $try;
        }
        else {
          $line=191;
          if ($opEqualY(q,"p_red")) {
            $line=191;
            $result=$opAdditY("P",s);
            if (true) break $try;
          }
          else {
            $line=192;
            if ($opEqualY(q,"fin_red")) {
              $line=192;
              $result=$opAdditY("F",s);
              if (true) break $try;
            }
            else {
              $line=193;
              if ($opEqualY(q,"Nom")) {
                $line=193;
                $result=$opAdditY("n",s);
                if (true) break $try;
              }
              else {
                $line=194;
                $result=s;
                if (true) break $try;
              }
            }
          }
        }
      }
      else {
        $line=196;
        $result="";
        if (true) break $try;
      }
      $line=199;
      $rethrow(new RuntimeException("The function \"h(q:Object,\u03C3:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,LexerParser.class,"h",$line);
    }
    return $result;
  }
}