title Operaciones con matrices (Prac2.ASM)


pila segment stack 
DB 100h DUP ('LOL') 
TOS EQU THIS WORD
pila ends

datos segment
 letrero DB "Practica 2",0ah,0ah,0dh,'$'
 
 integrantes DB "Integrantes de equipo 3:",0ah,0dh
	         DB "Angel David Tellez Macias 210201977",0ah,0dh
	         DB "Miguel Aristeo Hernandez Velasco 210203686",0ah,0dh,0ah,'$'
	     
 longitud DB 6
          DB ?
          
 valores DB 6 DUP(0)         	    
 
 menu DB 0ah,"Menu",0ah,0dh
      DB "1.Suma de matrices",0ah,0dh
      DB "2.Resta de matrices",0ah,0dh
      DB "3.Salir", 0ah,0ah,0dh,'$'
      
 suma DB 0ah,"Suma de matrices",0ah,0dh,'$'
 
 resta DB 0ah,"Resta de matrices", 0ah,0ah,0dh,'$'
 
datos ends

codigo segment 'code' 
assume ss:pila, cs: codigo, ds:datos

main proc 

mov ax, seg pila 
mov ss,ax 

mov sp,OFFSET TOS

mov ax, seg datos
mov ds, ax


mov dx,offset letrero
mov ah, 9
int 21h

mov dx,offset integrantes
mov ah, 9
int 21h

eti1:
mov dx,offset menu
mov ah, 9
int 21h

mov ah,1 ; input a character 
int 21h ; AL = character


cmp al, '1'
je B1
cmp al, '2'
je B2
cmp al, '3'
je exit
cmp al, 3
ja eti1

B1: mov dx,offset suma
mov ah, 9
int 21h
jmp eti1

B2: mov dx,offset resta
mov ah, 9
int 21h
jmp eti1

exit: mov ax,4C00h ; return to DOS
int 21h
main endp

codigo ends
end main
