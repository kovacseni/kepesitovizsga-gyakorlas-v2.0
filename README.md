# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd!
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz! A `pom.xml` tartalmát nyugodtan át lehet másolni.
Projekt, könyvtár, repository neve legyen: `kepesitovizsga-gyakorlas-v2.0`.
GroupId: `training`, artifactId: `kepesitovizsga-gyakorlas-v2.0`. Csomagnév: `hu.nive.ujratervezes.kepesitovizsga`.

A feladatok megoldásához ajánlom figyelmedbe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

A három (de ötnek számító) feladatra 3 órád van összesen!

Oldd meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő az első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Húsvéti nyulak és tojások

Az eggs.csv fájlban megtalálható, hogy melyik húsvéti nyuszi hány hímes tojást hordott szét a világban.
A fájl felhasználásával írj egy `getRabbitWithMaxEggs()` metódust az Eggs osztályba, amely visszaadja a legtöbbet
dolgozó nyuszi nevét és a tojások számát!

## Építésziroda

Az ArchitectStudio osztály tárol és kezel egy adatszerkezetet, amelyben az egyszerű elérhetőség kedvéért az irodában,
egymás közötti beszélgetésben használatos "munkacímükkel" kereshetőek vissza a régebbi épülettervek.
A tervekről a következőket kell tudni:
- A Plan egy interfész, három metódust tartalmaz: `String getProjectName()`, `int calculateSquareMeter()` és `PlanType getType()`.
- Az építésziroda háromféle típusú épületre specializálódott, amelyek mind implementálják ezt az interfészt: lakóépületekre 
  (ResidentialBuildingPlan), középületekre (PublicBuildingPlan) és ipari épületekre (IndustrialBuildingPlan). Ezeknek mindnek
  van egy PlanType enum attribútuma: RESIDENTIAL, PUBLIC, INDUSTRIAL. Minden tervnek van egy String projectName attribútuma is, 
  amely nem egyenlő a korábban említett "munkacímmel", ez az adott építészeti projekt hivatalos neve.
- A ResidentialBuildingPlan további attribútumai a következők: House house, int stock, és int area. A House egy enum,
  amelynek három példánya a lakóházak különböző típusai szerint: FAMILY_HOUSE, APARTMENT_BUILDING, BLOCK_OF_FLATS. A stock az 
  adott épület szintjeinek száma, az area pedig egy szintjének alapterülete. A `calculateSquareMeter` metódus az épület
  teljes alapterületét adja vissza: alapterület szorozva a szintek számával.
- A PublicBuildingPlan további attribútumai a következők: int stock és int area, ugyanazok érvényesek rájuk, mint a lakóépületeknél,
  a `calculateSquareMeter` metódus is ugyanúgy kell, hogy számoljon.
- Az IndustrialBuildingPlan további attribútumai a következők: int areaOfOfficeBlock, int stock, int areaOfManufacturingHall. Egy
  ipari épület felépítése a következőképpen néz ki: van egy irodaépület, amely lehet többszintes is, és van egy üzemcsarnok,
  amely mindenképpen egyszintes. A `calculateSquareMeter` metódus ennek megfelelően az irodaépület alapterületét beszorozza
  a szintek számával és ehhez adja hozzá az üzemcsarnok alapterületét.
  
Az építésziroda a következő metódusokat valósítja meg:
- `addPlan(String workingTitle, Plan plan)` : az iroda által kezelt adatszerkezethez egy új tervet ad úgy, hogy külön megkapja
  paraméterként a "munkacímet" és magát a tervet.
- `getPlanWithMaxSquareMeter()` : visszaadja a legnagyobb össz-alapterületű épület tervét.
- `getPlanByWorkingTitle(String workingTitle)` : munkacím alapján kikeres egy tervet.
- `getPlanByProjectName(String projectName)` : projektnév alapján keres ki egy tervet.
- `getSmallerPlans(int squareMeter)` : visszaadja a megadott paraméternél kisebb össz-alapterületű épületek terveinek listáját.
- `getListOfPlansByPlanType(PlanType type)` : visszaadja a paraméterként megadott típusú épületterveket.

Kezeld a kivételeket mindenhol, ahol csak szükséges!

## Szótár

Ezzel a feladattal egy szótár alkalmazás működését szimulálhatod.
Hozz létre egy adatbázist, amelyben egyetlen tábla lesz: ez a szótárban található szavak magyar és angol megfelelőjét tartalmazza. 
A szótár működése nagyon egyszerű: kell két metódus, `getEnglishWord(String hungarianWord)` és `getHungarianWord(String englishWord)` .
Az egyik egy magyar szót vár és annak angol megfelelőjét adja vissza, a másik egy angol szót vár és annak a magyar megfelelőjét adja vissza.
