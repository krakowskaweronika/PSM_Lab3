# Konspekt 3. Sprawozdanie
Autor: Weronika Krakowska

## Zrzuty ekranu gotowej aplikacji
<img width="482" height="959" alt="1" src="https://github.com/user-attachments/assets/9b3706ad-43f0-4df4-9f08-76ea37702a0c" />
<img width="482" height="965" alt="2" src="https://github.com/user-attachments/assets/ddd8ef90-2ea1-486a-8dbf-46dbdae21d10" />

## Zrzuty ekranu z licznikiem pokazującym formę "żartów"
<img width="477" height="965" alt="3" src="https://github.com/user-attachments/assets/8f31206b-f109-40d3-a17b-bee3a972b71a" />
<img width="472" height="956" alt="4" src="https://github.com/user-attachments/assets/5b2ab8fa-e4e5-4906-b27f-a0cbf7211ad0" />


## Zrzut ekranu w pseudojęzyku i lista poprawek
<img width="480" height="954" alt="pseudo" src="https://github.com/user-attachments/assets/4e53d6ed-281b-4db2-ae50-6de386b31698" />

Lista poprawek:

1. Główny przycisk miał sztywny rozmiar 150.dp, przez co wydłużony tekst w pseudojęzyku łamał się nienaturalnie lub wychodził poza krawędzie, należało zwiększyć jego rozmiar.
2. Teksty licznika oraz powitania były zbyt blisko krawędzi ekranu przy długich łańcuchach znaków, należało zabezpieczyć je bocznymi marginesami (padding(horizontal = 16.dp)).

## Dlaczego warunek sprawdzający liczbę pojedynczą jest w j. polskim niewystarczający?
W języku angielskim wystarczy prosty warunek sprawdzający liczbę pojedynczą (one) i mnogą (other). W języku polskim jest to niewystarczające, 
ponieważ według reguł CLDR polszczyzna posiada aż cztery kategorie form gramatycznych: 
one (1 żart), few (np. 2, 3, 4 żarty), many (np. 5, 10, 25 żartów) oraz other (np. ułamki).
Zapisanie tego warunkami if/else w kodzie jest niepraktyczne i nie skaluje się na inne języki, dlatego należy korzystać z mechanizmu <plurals> zasobów Androida.

## Który zestaw zasobów powinien być domyślny i dlaczego?
Domyślnym zestawem zasobów (katalog res/values bez żadnego sufiksu językowego) powinien być język angielski. Android ładuje zasoby z tego katalogu zawsze,
gdy nie znajdzie tłumaczenia pasującego do języka ustawionego w systemie telefonu (tzw. "fallback"). Ponieważ angielski jest uniwersalnym językiem międzynarodowym, 
gwarantuje to, że użytkownicy z krajów, dla których nie przygotowano dedykowanego tłumaczenia, nadal będą w stanie korzystać z aplikacji.
