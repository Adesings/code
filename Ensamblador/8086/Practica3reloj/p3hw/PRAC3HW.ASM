title Practica 3 Reloj (Prac3.ASM)
; Programa que muestra la hora
pila segment stack 
DB 100h DUP ('pila') 
TOS EQU THIS WORD
pila ends

datos segment
 
 ;Practica 3
 
 ;Integrantes de equipo 3
 ;Angel David Tellez Macias 210201977
 ;Miguel Aristeo Hernandez Velasco 210203686

 puntos DB ":",'$' ;caracter 

 newline DB " hora ",0dh,'$' ;letrero hora
 
 h DB 1 DUP(0) 	;variable que guarda las horas
 m DB 1 DUP(0)	;variable para guardar los minutos 
 s DB 1 DUP(0)  ;variable para guardar los segundos
 hd DB 2 DUP(0) ;guarda horas en decimal
 md DB 2 DUP(0) ;guarda minutos en decimal
 sd DB 2 DUP(0) ;guarda segundos en decimal
 
 cont1 DB 2 DUP(0) ;variable
 cont2 DB 2 DUP(0) ;variable
 cont18 DB 1 DUP(0);variable  
datos ends

codigo segment 'code' 
assume ss:pila, cs: codigo, ds:datos ;indica los nombres de cada segmento al ensamblador

main proc 		;programa principal

mov ax, seg pila  	;inicializa segmento pila
mov ss, ax
mov sp, offset TOS

mov ax, seg datos	;inicializa segmento datos
mov ds, ax

;------------Cambio de vector-----------------
push ds
mov ax,cs
mov ds,ax
mov dx, offset tiempo
mov al, 1Ch 
mov ah, 25h
int 21h
pop ds

mov ah, 2Ch 		;servicio 2ch para obtener la hora del sistema, se guarda en 
int 21h			;ch,cl,dh,cl



	
mov h, ch 		;se guarda en h el contenido de ch que contiene la hora
mov m, cl		;se guarda en h el contenido de cl que contiene los minutos
mov s, dh		;se guarda en h el contenido de dh que contiene los segundos



mov cont18, 18h		;inicializa cont18 con 18h

;ciclo3:	call deshora 	;llama a la subrutina que despliega la hora
eti:	mov cont1, 0ffffH ;inicializa cont1 con ffffh
   
ciclo1: mov cont2, 0ffffH ;inicializa cont2 con ffff

ciclo: dec cont2	;decrementa cont2 en uno

jnz ciclo		;si no es cero brinca a ciclo 
dec cont1		;si es cero decrementa cont1 
jnz ciclo1		;si no es cero brinca a ciclo1 
;call tiempo 		llama a subrutina tiempo que arregla los s, m y h
;int 1ch
jmp eti			;brinca  a eti

mov ax,4C00h ; return to DOS
int 21h
main endp

tiempo proc uses ax bx cx dx ;subrutina tiempo
	
	dec cont18	;decrementa cont18 en uno
	jnz ciclo2 	;si no es cero brinca a ciclo2
	
	inc s		;si es cero incrementa s en uno 
	
	mov cont18, 18h ;inicializa cont18 con 18h	
	mov al,03cH 	;compara a s con 60
	cmp al, s 
	jne ciclo2 	;si no es cero brinca a ciclo3
	mov s,00h	;si es cero se mueve 0 a s 
	
	
	inc m		;se incrementa m en uno
	
	mov al, 03cH	;se compara m con 60
	cmp al, m
	jne ciclo2	;si no es cero brinca  a cilco3
	mov m, 00h	;si es cero se mueve 0 a m
	
	inc h		;se incrementa h en uno
	
	mov al, 018h	;se compara h con 24 
	cmp al, h
	jne ciclo2	;si no es cero brinca a ciclo3 
	mov h, 00h	;si es cero se mueve 0 a h
	
		;brinca a ciclo3
ciclo2:	call deshora
	iret 		;retorno de subrutina

tiempo endp		;termina subrutina tiempo

deshora proc uses ax bx cx dx ;subrutina despliega hora
	
	mov dx, offset newline ;imprime letrero hora
	mov ah,9
	int 21h
	
	mov al,h	;convierte hora hexadecimal a ascii
	aam
	or ax, 3030h
	mov hd+1,al
	mov hd,ah
	
	mov bx,offset hd ;imprime hora decimal 
	mov dx,[bx]
	mov ah,2
	int 21h
	mov dx,[bx+1]
	mov ah,2
	int 21h

	mov dx, offset puntos ;imprime dos puntos
	mov ah, 9
	int 21h
	
	
	mov al,m	;convierte minutos hexadecimal a ascii
	aam
	or ax, 3030h
	mov md+1,al
	mov md,ah
	
	
		
	
	mov bx, offset md ;imprime minutos decimal
	mov dx,[bx]
	
	mov ah,2
	int 21h
	mov dx,[bx+1]
	mov ah,2
	int 21h

	mov dx, offset puntos ;imprime dos puntos
	mov ah, 9
	int 21h
	
	mov al,s	;convierte segundos hexadecimal a ascii
	aam
	or ax, 3030h
	mov sd+1,al
	mov sd,ah
	
	
	mov bx,offset sd ;imprime segundos decimal
	mov dx,[bx]
	mov ah,2
	int 21h
	mov dx,[bx+1]
	mov ah,2
	int 21h
	

ret		;retorno de subrutina deshora
deshora endp	;termina subrutina deshora




codigo ends 	;fin de segmento de codigo
end main	;fin programa principal