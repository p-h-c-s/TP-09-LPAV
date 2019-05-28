## LABORATÓRIO	DE	PROGRAMAÇÃO	AVANÇADA

## CURSO	DE	CIÊNCIA	DA	COMPUTAÇÃO

## THREADS	E	MONITORES

**SOMATÓRIO (4.0 pontos)**

Implemente um programa com **k** threads para **somar** um vetor de **N** números gerados
**aleatoriamente**. As threads vão somar os valores localmente e, depois, vão
incrementar **uma única variável global** protegida por um **semáforo** MUTEX, que
pode ser facilmente implementado por um **monitor** de tamanho igual a 1.

A ideia é “dividir” **o vetor em k partes** e passar os índices de início e fim de cada
parte para a respectiva thread. Por exemplo, suponha que N = 2000 e k = 4, nesse
caso, cada thread vai ficar responsável por somar 500 valores. Neste caso particular, a
thread[0] vai receber os valores 0 (início) e 499 (fim); thread[1] vai receber os valores
500 (início) e 999 (fim); thread[2] vai receber os valores 1000 (início) e 1499 (fim); e
thread[3] vai receber os valores 1500 (início) e 1999 (fim).

Escreva uma **relatório** que avalie o tempo de execução para os seguintes valores de
N: 1024, 2048, 4096, 8192, 16384 , 32768 , 65536 ; e para os seguintes valores de k: 1,
2, 4, 8, 16, 32 e 64. Quer dizer, avalie N=10 24 e k=1, depois avalie N= 1024 e k=2,
depois avalie N= 1024 e k=4; e assim por diante. O relatório deve ter mais ou menos o
seguinte formato:

## 1024 2048 4096 8192 16384 32768 65536

## 1

## 2

## 4

## 8

## 16

## 32

## 64

A estratégia que usa k=1 é simplesmente criar uma única thread. A razão é ser mais
“justo” na comparação dos tempos com as outras quantidades de threads.

A medição do tempo de execução pode ser feita daseguinte forma:

```
long start = System.currentTimeMillis();
```
**...
long elapsed = System.currentTimeMillis() - start;**


**BARREIRAS (3.0	pontos)**

Uma forma	de	se	fazer	sincronização em	sistemas	concorrentes	é	a	chamada	
**barreira** .	Neste	caso,	a barreira	impõe	que	os	vários	processos/threads	só	
podem	prosseguir	a	execução	após	todos	chegarem	no	mesmo	ponto	de	
sincronização,	isto	é,	na	barreira.

Usando	monitores,	é	possível	que	diversas	threads	sincronizem	em	um	único	
método.	Vamos	assumir	que	tal	método	do	monitor	chama-se	 **sync** .	Implemente	

um	monitor	em	Java	chamado	 **Barrier** com	o	método	 **sync()** que	garante	que	
todas	as	N	threads	só	devem	chamar	synch()	antes	que	todas	possam	prosseguir	
com	as	respectivas	execuções.	

Faça	um	programa	que	instancie	N	threads	(passado	como	parâmetro	de	linha	de	
comando)	que	execute	o	seguinte	código:	imprima	o	seu	thread_id	+	“primeira	
execução”;	chegue	até	a	barreira;	imprima	novamente	o	seu	thread_id	+	“segunda	
execução”;	chegue	novamente	até	a	barreira;	e	imprima	o	seu	thread_id	+	“fim	da	
execução”.

**O	PROBLEMA	DA	CONTA	DE	POUPAÇA ( 3 .0	pontos)**

Uma	conta	poupança	é	compartilhada	por	várias	pessoas.	Cada	pessoa	pode	
depositar	ou	retirar	fundos	da	conta	sujeita	à	restrição	que	o	saldo	da	conta	
nunca	deve	se	tornar	negativo.	Desenvolva	uma	implementação	Java	de	um	
MONITOR	para	a	conta	poupança.	Estabeleça	o	valor	do	saldo	inicial.	Faça	um	
programa	que	gere	N	threads	de	pessoas que	usam	esta	mesma	conta	poupança.	
Cada	pessoa	vai	depositar	e	sacar	valores	M	vezes.	A	cada	depósito/saque	o	valor	
atual	do	saldo	deve	ser	impresso.

**OBSERVAÇÕES:**

- Se	por	acaso	a	especificação do	problema não	estiver	totalmente	clara,	
    por	favor	incluam	em	um	arquivo	README	todas	as	 **suposições**
- Enviar	os	CÓDIGOS e	o	relatório para	o	email	do	 **professor** e	do	 **monitor**
- Por	favor,	coloquem no	assunto	do	email:	 **[LPAv-TP09]**
- - -
Data	de	entrega:	 **30/05/2018** (quinta-feira,	até	meia-noite)
Após	este	prazo	sera	descontado	 **0,1	por	hora** (ou	fração)	de	atraso.


