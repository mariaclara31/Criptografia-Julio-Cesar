package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CriptografiaCesariana implements Criptografia {
    List<String> listText = new ArrayList<>();

    @Override
    public String criptografar(String text) {

        return realizeConvertion(text, 3);

    }

    @Override
    public String descriptografar(String text) {

        return realizeConvertion(text, -3);

    }
    private String realizeConvertion(String text, int codificador) {
        validateText(text);
        char[] arrayText = text.toCharArray();

        for(char value : arrayText) listText.add(Character.toString(value));
        return listText.stream()
                .map(c -> modifyCharacter(0, c, codificador))
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toLowerCase();
    }
    private char modifyCharacter(int index, String list, int codificador) {
        return (Character.isDigit(list.charAt(index)) || !Character.isLetter(list.charAt(index)))
                ?list.charAt(index) : (char) (list.charAt(index) + codificador);
    }
    private void validateText(String text) throws IllegalArgumentException {
        if(text.isEmpty()) {
            throw new IllegalArgumentException("Erro! Por favor informe um texto. ");
        }
    }
}
