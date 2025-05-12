---
Authors:
  - Silvio Santoriello
  - |
    silvio.santoriello@edu.unifi.it
  - |
    Edoardo Stefanacci
  - |
    edoardo.stefanacci@edu.unifi.it
Title: |
  Implementazione di un albero n-ario in Java - Algoritmi e Strutture Dati 24/25
---

<p align="center">
<img src="https://e-l.unifi.it/Logo%20Unifi%20bianco%20bordo.png">
</p>

# Progetto Algoritmi e Strutture Dati 2024/2025

Il seguente progetto consiste nell'implementazione in linguaggio Java di una struttura dati di tipo Albero N-Ario tramite due strutture indicizzate (Array) contenenti i Nodi dell'albero ed i riferimenti ai rispettivi padri. L'intero codice si basa su due classi principali, AlberoVP e NodoVP, le quali ospitano i metodi dedicati ad eseguire operazioni sull'intero albero o su di uno specifico nodo.

## Overview dei metodi relativi alla classe AlberoVP

La classe `AlberoVP<T>` implementa una struttura ad albero generico in cui ogni nodo può avere un numero arbitrario di figli. È costruita per essere flessibile e facilmente navigabile, mantenendo una lista dei nodi (`nodesList`) e dei relativi padri (`parentList`) per consentire operazioni rapide e coerenti sulla struttura.

### Costruttori

- `AlberoVP()`<br>Crea un albero vuoto.
- `AlberoVP(NodoVP<T> root)`<br>inizializza l’albero con un nodo radice. Il nodo radice non ha padre e viene impostato al livello 0.

### Gestione della Radice

- `setRootInEmptyTree(NodoVP<T> root)`<br>Permette di impostare una radice in un albero inizialmente vuoto.
- `setRootNotEmpty(NodoVP<T> newRoot)`<br>Consente di sostituire la radice attuale con un nuovo nodo. Il vecchio nodo radice diventa figlio della nuova radice. L’intero albero viene aggiornato di conseguenza, incluso il livello dei nodi.

### Metodi getter e setter

- `getRoot()`<br>Restituisce il nodo radice dell'albero.
- `getParent(NodoVP<T> n)`<br>Restituisce il nodo padre del nodo specificato.
- `getChildList(NodoVP<T> n)`<br>Restituisce la lista dei figli di un nodo.
- `getChildListSize(NodoVP<T> n)`<br>Restituisce il numero di figli del nodo specificato.
- `getNodeInfo(NodoVP<T> n)`<br>Restituisce l'informazione contenuta nel nodo.
- `setNodeInfo(NodoVP<T> n, T info)`<br>Imposta una nuova informazione per il nodo.
- `getNodeLevel(NodoVP<T> n)`<br>Restituisce il livello (profondità) di un nodo, partendo dalla radice a livello 0.
- `getNodeLeavesSize(NodoVP<T> n)`<br>Restituisce il numero di foglie (nodi terminali) discendenti dal nodo specificato.

### Aggiunta di nuovi Nodi

- `addNodeChild(NodoVP<T> parent, NodoVP<T> child)`<br>Aggiunge un nuovo figlio al nodo parent. Questo metodo aggiorna automaticamente il padre del nodo figlio, il livello e le liste interne dell'albero.

### Informazioni sull'albero

- `getNodesListSize()`<br>Restituisce il numero totale di nodi nell’albero.
- `getHeight()`<br>Calcola e restituisce l’altezza dell’albero, cioè il livello massimo raggiunto da un nodo.

### Visite

- `visitaBF()`<br>Esegue una visita in ampiezza (Breadth-First), restituendo i nodi nell’ordine in cui verrebbero esplorati livello per livello.
- `visitaDF()`<br>Esegue una visita in profondità (Depth-First), restituendo i nodi nell’ordine di una visita pre-order. È implementata ricorsivamente.

### Stampa

- `toString()`<br>Restituisce una rappresentazione testuale dell’albero a partire dalla radice, mostrando ricorsivamente tutti i figli.<br>**Esempio:** `Claudia[Marco[Silvia[], Ugo[]], Luca[], Giulia[Andrea[Carlo[]], Gianna[]]]`

## Overview dei metodi relativi alla classe NodoVP

La classe `NodoVP<T>` rappresenta un singolo nodo all’interno di un albero generico. Ogni nodo può contenere un’informazione di tipo generico T, un riferimento al proprio nodo padre, una lista di figli e un numero intero che rappresenta il livello (profondità) del nodo nell’albero.

### Costruttore

- `NodoVP(T info)`<br>Crea un nodo contenente l’informazione `info`. Inizialmente il nodo non ha padre né figli, il livello deve essere impostato separatamente.

### Accesso ai dati

- `getInfo()`<br>Restituisce l’informazione contenuta nel nodo.
- `getParent()`<br>Restituisce il nodo padre.
- `getChildList()`<br>Restituisce la lista dei figli del nodo.
- `getChildListSize()`<br>Restituisce il numero di figli del nodo.
- `getLevel()`<br>Restituisce il livello (profondità) del nodo nell’albero, con la radice al livello 0.
- `getLeavesSize()`<br>Restituisce il numero di figli del nodo che sono foglie (cioè che non hanno a loro volta figli).

### Modifica dei dati

- `setInfo(T info)`<br>Imposta una nuova informazione nel nodo.
- `setParent(NodoVP<T> parent)`<br>Imposta il nodo padre del nodo corrente.
- `setLevel(int level)`<br>Imposta il livello del nodo nell’albero.
- `addChild(NodoVP<T> child)`<br>Aggiunge un nuovo figlio al nodo e aggiorna automaticamente il livello del figlio.
- `addChild(NodoVP<T> child, T info)` <br>**(Deprecated)** — Aggiunge un figlio sovrascrivendone l’informazione. Questo metodo non è utilizzato nella nostra implementazione.
