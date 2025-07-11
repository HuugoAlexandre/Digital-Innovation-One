package sudoku;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import sudoku.model.Board;
import sudoku.model.Space;

public class Main {
	
	private final static Scanner scanner = new Scanner(System.in);
	private final static int BOARD_LIMIT = 9;
	private static Board board; 

	public static void main(String[] args) {
		final var positions = Stream.of(args)
				.collect(toMap(k -> k.split(";")[0], v -> v.split(";")[1]));
		
		var option = -1;
		while(true) {
			System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");
            
            option = scanner.nextInt();
            
            switch(option) {
	            case 1 -> startGame(positions);
	            case 2 -> inputNumber();
	            case 3 -> removeNumber();
	            case 4 -> showCurrentGame();
	            case 5 -> showGameStatus();
	            case 6 -> clearGame();
	            case 7 -> finishGame();
	            case 8 -> System.exit(0);
	            default -> System.out.println("Seleção inválida, selecione uma opção válida.");
            }
		}
	}
	
	private static void startGame(Map<String, String> positions) {
		if(nonNull(board)) {
			System.out.println("O jogo já foi iniciado!");
			return;
		}
		
		List<List<Space>> spaces = new ArrayList<>();
		for (int i = 0; i < BOARD_LIMIT; i++) {
			spaces.add(new ArrayList<>());
			for(int j = 0; j < BOARD_LIMIT; j++) {
				var positionConfig = positions.get("%s, %s".formatted(i, j));
				var expected = Integer.parseInt(positionConfig.split(",")[0]);
				var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
				var currentSpace = new Space(expected, fixed);
				spaces.get(i).add(currentSpace);
			}
		}
		board = new Board(spaces);
		System.out.println("O jogo está pronto para começar!");
	}

	private static void finishGame() {
		// TODO Auto-generated method stub
		
	}

	private static void clearGame() {
		// TODO Auto-generated method stub
		
	}

	private static void showGameStatus() {
		// TODO Auto-generated method stub
		
	}

	private static void showCurrentGame() {
		// TODO Auto-generated method stub
		
	}

	private static void removeNumber() {
		if(isNull(board)) {
			System.out.println("O jogo ainda não foi iniciado!");
			return;
		}
		
		System.out.println("Informe a coluna: ");
		var col = runUntilGetNumber(0,8);
		System.out.println("Informe a linha: ");
		var row = runUntilGetNumber(0,8);
		System.out.printf("Agora o número na posição [%s, %s]\n: ", col, row);
		if(!board.clearValue(col, row)) {
			System.out.printf("A posição [%s, %s] tem um valor fixo! \n", col, row);
		}
		
	}

	private static void inputNumber() {
		if(isNull(board)) {
			System.out.println("O jogo ainda não foi iniciado!");
			return;
		}
		
		System.out.println("Informe a coluna: ");
		var col = runUntilGetNumber(0,8);
		System.out.println("Informe a linha: ");
		var row = runUntilGetNumber(0,8);
		System.out.printf("Agora o número na posição [%s, %s]\n: ", col, row);
		var value = runUntilGetNumber(1,9);
		if(!board.changeValue(col, row, value)) {
			System.out.printf("A posição [%s, %s] tem um valor fixo! \n", col, row);
		}
		
	}
	
	private static int runUntilGetNumber(final int min, final int max) {
		var current = scanner.nextInt();
		while (current < min || current > max) {
			System.out.printf("Informe um valor entre %s e %s\n", min, max);
			current = scanner.nextInt();
		}
		return current;
	}
}
