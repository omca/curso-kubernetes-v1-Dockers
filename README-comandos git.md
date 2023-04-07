###GIT RESET
Es un comando para deshacer cambios y para movernos y saltar entre varios commits

- soft -> mover hacia atras en el historial sin perder los cambios, solo cambio el puntero del HEAD
- hard -> mover al historico pero pierde los cambios, elimina los commits. (es mas peligroso realizar este cambio)

$ git log --oneline

### 1. GIT RESET HARD  (elimina los cambios del  working directory)

1. elimina los cambios actuales sin comitear y vuelve al ultimo commit forzozamente (si no comiteamos nada, se perderán los cambios) 
- $ git reset --hard
   
2. elimina el ultimo commit en el working directory y retorna al penultimo commit.
- $ git reset --hard HEAD^
- $ git push -f <NOMBRE-REMOTO> <RAMA-LOCAL>
- $ git push -f origin main  (forzar el push hacia el repo remoto)

### 2. GIT RESET SOFT  (mantiene los cambios del  working directory)
Sirve para cambiar a un commit SHA en especifico. 
La diferencia es que vuelve a un cgommit en especifico pero mantiene los cambios en el Working directory (localhost)
s
- $ git reset --soft #idcomit#

es recomendable usar el reset --soft en vez de usar el reset --hard

### 3. GIT REVERT
Revierte el commit actual, pero agrega un nuevo commit con su reversion. Y como parametro
se le manda el commit a donde quiere ser revertido. 
Al revertir a un commit especifico no elimina ningun cambio del Working directory y hace un merge automatico,
sino se tiene que hacer manual.

El REVERT es para mantener los cambios en el history.

- $ git revert #idcommit#
- $ git revert --continue

FUSIONAR RAMAS
$ feature> git rebase master  (oculta los commits de la rama feature, y trae los commits de master, y al final pone los commits ocultos al inicio)
$ git merge feature (al final hace un merge con feature pero de forma fast-forward)

### MODIFICAR MENSAJE DE UN COMMIT EXISTENTE
ver commits con archivos modificados
- $ git log --stat

agregar archivos  a un commmit
$ git commit --no-edit --amend


### AGREGAR ARCHIVOS A COMMITS YA EXISTENTES
ver commits con archivos modificados
- $ git log --stat

agregar archivos  aun commmit
$ git commit --no-edit --amend


###GIT REBASE
es un comando que nos permite alterar el historial de commits: 
- Puedes modificar los mensajes comiteados  (git commit amend)
- Puedes fusionar commits (squash)

1. PASO 1 REBASE
> $ git rebase -i HEAD~2
> el git rebase muestra los commits de manera inversa como te los muestra el git log
> $ esc + i
> $ escribir 'edit' en el commit que quieres modificar el mensaje  (editar la primer alinea pick por edit)
> $ git commit -m "update commit ciwht rebase" --amend
2. PASO 2 REBASE
> $ git rebase --continue
> $ git log --oneline 
> $ git push -f origin main
=======
No solo modifica el ultimo commit, sino nos da la posibilidad de actualizar cualquier commit. 
> $ git rebase -i HEAD~2
> el git rebase temuestra los commits de manera inversa como te los muestra el git log
> $ esc + i
> $ escribir 'edit' en el commit que quieres modificar el mensaje
> $ git commit -m "update commit ciwht rebase" --amend
> $ git rebase --continue
> $ git log --oneline 

> No solo modifica el ultimo commit, sino cualquier commit. 
> $ git rebase -i  

###GIT REBASE SQUASH
el rebase squash va a fusionar todo en el ultimo commit
> $ git rebase -i HEAD~2
> $ esc + i
> $ pick 342932
> $ squash 23232
- abre una siguiente ventana 
- nos muestra los 2 commits y solo nos quedamos con uno, y se genera un nuevo hash (tener cuidado con el uso de este comando, ya que si pusheamos en el remote puede generar conflictor y sobreescribir cambios de otros usuarios)



###GIT CHERRY PICK
- es un comando para llevar commits de una rama hacia otra rama
- su uso es para traer funcionalidades antiguas de alguna rama que se trabajó hace tiempo

### ELIMINAR UN COMMMIT  PUNTUAL



## COMANDOS AVANZADOS

#### 1. CREAR Y SUBIR NUEVA RAMA AL REPO REMOTE
$ git checkout 232j23
$ git checkout -b oldFeature1  (nuevo branch en base al commit)
$ git push --set-upstream origin oldFeature1 (pushea la rama en el repo remote)

#### VER LOG INTERACTIVO
$ git log --oneline --decorate --all --graph




hola 1
hola 2
hola 3
