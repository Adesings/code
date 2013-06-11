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
 
   
datos ends

codigo segment 'code' 

assume ss:pila, cs: codigo, ds:datos ;indica los nombres de cada segmento al ensamblador
 
 h DB 1 (0) 	;variable que guarda las horas
 m DB 1 (0)	;variable para guardar los minutos 
 s DB 1 (0)  ;variable para guardar los segundos
 hd DB 2 DUP(0) ;guarda horas en decimal
 md DB 2 DUP(0) ;guarda minutos en decimal
 sd DB 2 DUP(0) ;guarda segundos en decimal
 
 cont1 DB 2 DUP(0) ;variable
 cont2 DB 2 DUP(0) ;variable
 cont18 DB 0;variable


tiempo proc uses ax bx cx dx ;subrutina tiempo
	
	dec cs:cont18	;decrementa cont18 en uno
	jnz ciclo2 	;si no es cero brinca a ciclo2
	
	inc cs:s		;si es cero incrementa s en uno 
	
	mov cs:cont18, 18h ;inicializa cont18 con 18h	
	mov al,03cH 	;compara a s con 60
	cmp al, cs:s 
	jne ciclo2 	;si no es cero brinca a ciclo3
	mov cs:s,00h	;si es cero se mueve 0 a s 
	
	
	inc cs:m		;se incrementa m en uno
	
	mov al, 03cH	;se compara m con 60
	cmp al, cs:m
	jne ciclo2	;si no es cero brinca  a cilco3
	mov cs:m, 00h	;si es cero se mueve 0 a m
	
	inc cs:h		;se incrementa h en uno
	
	mov al, 018h	;se compara h con 24 
	cmp al, cs:h
	jne ciclo2	;si no es cero brinca a ciclo3 
	mov cs:h, 00h	;si es cero se mueve 0 a h
	
	;jmp ciclo3	brinca a ciclo3
ciclo2:	call deshora
	iret 		;retorno de subrutina

tiempo endp		;termina subrutina tiempo

deshora proc uses ax bx cx dx ;subrutina despliega hora
	
	mov bh,0;
	mov dh,12
	mov dl,40
	mov ah,2
	int 10h
	

	;mov dx, offset newline ;imprime letrero hora
	;mov ah,9
	;int 21h
	
	mov al,cs:h	;convierte hora hexadecimal a ascii
	aam
	or ax, 3030h
	mov cs:hd+1,al
	mov cs:hd,ah
	
	mov bx,offset hd ;imprime hora decimal 
	mov dx,cs:[bx]
	mov ah,2
	int 21h
	mov dx,cs:[bx+1]
	mov ah,2
	int 21h

	mov dl, ':' ;imprime dos puntos
	mov ah, 2
	int 21h
	
	
	mov al,cs:m	;convierte minutos hexadecimal a ascii
	aam
	or ax, 3030h
	mov cs:md+1,al
	mov cs:md,ah
	
	
		
	
	mov bx, offset md ;imprime minutos decimal
	mov dx,cs:[bx]
	
	mov ah,2
	int 21h
	mov dx,cs:[bx+1]
	mov ah,2
	int 21h

	mov dl, ':' ;imprime dos puntos
	mov ah, 2
	int 21h
	
	mov al,cs:s	;convierte segundos hexadecimal a ascii
	aam
	or ax, 3030h
	mov cs:sd+1,al
	mov cs:sd,ah
	
	
	mov bx,offset sd ;imprime segundos decimal
	mov dx,cs:[bx]
	mov ah,2
	int 21h
	mov dx,cs:[bx+1]
	mov ah,2
	int 21h
	

ret		;retorno de subrutina deshora
deshora endp	;termina subrutina deshora





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
mov al, 1ch 
mov ah, 25h
int 21h
pop ds

mov ah, 2Ch 		;servicio 2ch para obtener la hora del sistema, se guarda en 
int 21h			;ch,cl,dh,cl



	
mov cs:h, ch 		;se guarda en h el contenido de ch que contiene la hora
mov cs:m, cl		;se guarda en h el contenido de cl que contiene los minutos
mov cs:s, dh		;se guarda en h el contenido de dh que contiene los segundos



mov cs:cont18, 18h		;inicializa cont18 con 18h

;ciclo3:	call deshora 	;llama a la subrutina que despliega la hora
;eti:	mov cs:cont1, 0ffffH ;inicializa cont1 con ffffh
   
;ciclo1: mov cs:cont2, 0ffffH ;inicializa cont2 con ffff

;ciclo: dec cs:cont2	;decrementa cont2 en uno

;jnz ciclo		;si no es cero brinca a ciclo 
;dec cs:cont1		;si es cero decrementa cont1 
;jnz ciclo1		;si no es cero brinca a ciclo1 
;		llama a subrutina tiempo que arregla los s, m y h
;int 63h
;jmp eti			;brinca  a eti
mov dx, offset main
mov ah,31h
int 21h

mov ax,4C00h ; return to DOS
int 21h
main endp

codigo ends 	;fin de segmento de codigo
end main	;fin programa principal