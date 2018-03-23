furps		https://docs.google.com/document/d/1_xJZVzPHNGE6L9zis3mPI7K1-dBuG6KsGtANON6oQ4E/edit?usp=sharing

use case	https://docs.google.com/document/d/1jBHcizlAGBDwcwdu2Rn2ziLKq4nXPOo_fPAWOyfBJBc/edit?usp=sharing

use case diagram https://drive.google.com/file/d/1-EDUuXhQuk7Dm2OlpWE5FIiaJIIZvJ2j/view

class diagram https://drive.google.com/file/d/1D17g1Acdq92GOGKm-qXN2zQz-n7szFKd/view?usp=sharing

kanban 	https://trello.com/invite/b/NdtzLB3d/ec03ab28b9101cc29e56dd8244b70dc2/carwash-5000

SSD   https://drive.google.com/file/d/1SrkJARtutap4iZXzB_-YyeJ2jFD7o4jW/view?usp=sharing

opgave beskrivelse https://docs.google.com/document/d/e/2PACX-1vTaq88kCAyWz5M12eHSc0U3tWu3HsKC2JG8ap2u6DZSr3_1pwtm_WeZszjedLM7HYxLaoiMtJB_s4cx/pub

metode navne:
Car class:
- getDirt();
- setDirt(int dirt);    sætter hvor snavset bilen er, fra 0-200
- wash(int rens);       mindsker dirt, fra 0-200, og printer en status ud, afhængig af tilblageværende "dirt" level.
- displayDirt();      printer dirt level

Customer class:
- wash1();            koster 300 dkk og fjerner 150 "dirt"
- wash2();            koster 200 dkk og fjerner 100 "dirt"
- wash3();            koster 100 dkk og fjerner 50 "dirt"
- createWashCard();     hvis der er nok penge på "customers" dankort (150) bliver der oprettet et washcard
- setMoneyDankort(double oney);     sætter penge på "customers" dankort
- depositWashCard(double money);    indsætter penge fra "customers" dankort til washcard, hvis der er penge nok på dankortet
- checkbalance();     printer saldo af washcard
- setWashCard(double money);     sætter washcard
- getCreditCard();
- getWashcard();

User class:
- User(username, password);
- getUsername();
- getPassword();
