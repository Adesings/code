title Test Alphabetic Input (Pract1.ASM)
; This program reads and displays characters
; until a nonalphabetic character is entered.

pila segment stack
	DB 100h DUP ('stack')
	TOS EQU THIS WORD
pila ends

datos segment
 letrero DB "Practica 1",0ah,0dh,'$' ; se crea el segmento de datos 
 integrantes DB "Integrantes",0ah,0dh 
	         DB "Angel David Tellez Macias 210201977",0ah,0dh 
	         DB "Miguel Aristeo Hernandez Velasco 210203686",0ah,0dh,'$'
datos ends

codigo segment 'code'
	assume ss:pila, cs: codigo, ds:datos 

main proc 
	mov ax,seg datos 
 	mov ds ,ax

	mov ax, seg pila 
	mov ss,ax
	mov sp,OFFSET TOS
 	
	mov dx, Offset letrero  
	mov ah, 9 
	int 21h

	mov dx, offset integrantes 
	mov ah, 9 
	int 21h

L1: 	mov ah,1 ; input a character 
	int 21h ; AL = character

call    Isalpha ; test value in AL
	jnz exit ; exit if not alphabetic
	jmp L1 ; continue loop
exit:
	mov ax,4C00h ; return to DOS
	int 21h
	main endp

; Isalpha sets ZF = 1 if the character
; in AL is alphabetic.

Isalpha proc 
	push ax ; save AX
		and al,11011111b ; clear bit 5
		cmp al,'A' ; check 'A'..'Z' range
		jb B1
		cmp al,'Z'
		ja B1
		test ax,0 ; ZF = 1
		B1:
	pop ax ; restore AX
ret

Isalpha endp
codigo ends
end main