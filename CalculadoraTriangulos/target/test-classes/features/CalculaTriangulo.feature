#language: pt
@AllCenarios
Funcionalidade: Calcular Triângulo

  Contexto: 
    Dado que devo calcular os três lados de um triangulo

  Cenário: Triangulo equilatero
    Quando informo lados iguais "1", "1" e "1" e efetivo o calculo
    Então sistema retorna mensagem informando a classificação "Triângulo Equilátero"

  Cenário: Triangulo escaleno
    Quando informo tres lados diferentes "1", "3" e "5" e efetivo o calculo
    Então sistema retorna mensagem informando a classificação "Triângulo Escaleno"

  Cenário: Triangulo isosceles
    Quando informo dois lados iguais "5", "5" e "6" e efetivo o calculo
    Então sistema retorna mensagem informando a classificação "Triângulo Isósceles"

  Cenário: Calcular sem informar nenhum lado do triângulo
    Quando nao informo valores e efetivo o cálculo
    Então sistema retorna mensagem de erro "Preencha todos os lados"

  Esquema do Cenário: Calcular lados com numeros decimais
    Quando informo valor decimal <lado1>, <lado2> e <lado3> e efetivo o calculo
    Então sistema retorna alerta de erro <alerta>

    Exemplos: 
      | lado1  | lado2  | lado3  | alerta                                                                       |
      | "10,7" | "5"    | "0"    | "Insira um valor válido. Os dois valores válidos mais próximos são 10 e 11." |
      | "5"    | "10,7" | "0"    | "Insira um valor válido. Os dois valores válidos mais próximos são 10 e 11." |
      | "5"    | "0"    | "10,7" | "Insira um valor válido. Os dois valores válidos mais próximos são 10 e 11." |
