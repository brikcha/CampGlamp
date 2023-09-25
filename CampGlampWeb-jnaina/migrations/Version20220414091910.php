<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220414091910 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE blog (id INT AUTO_INCREMENT NOT NULL, nomBlog VARCHAR(255) NOT NULL, descriptionBlog VARCHAR(255) NOT NULL, imgBlog VARCHAR(255) NOT NULL, idUser INT NOT NULL, INDEX idUser (idUser), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('DROP TABLE event_user');
        $this->addSql('ALTER TABLE activite CHANGE id id INT AUTO_INCREMENT NOT NULL, CHANGE nombre de participants relation_id INT DEFAULT NULL, ADD PRIMARY KEY (id)');
        $this->addSql('ALTER TABLE activite ADD CONSTRAINT FK_B87555153256915B FOREIGN KEY (relation_id) REFERENCES event (id)');
        $this->addSql('CREATE INDEX IDX_B87555153256915B ON activite (relation_id)');
        $this->addSql('ALTER TABLE avis CHANGE idAvis idAvis INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idAvis)');
        $this->addSql('CREATE INDEX idUser ON avis (idUser)');
        $this->addSql('CREATE INDEX idEvenement ON avis (idEvenement)');
        $this->addSql('ALTER TABLE camp_service ADD PRIMARY KEY (idService, idCentre)');
        $this->addSql('ALTER TABLE camp_service ADD CONSTRAINT FK_910ED9BCA5B142EF FOREIGN KEY (idCentre) REFERENCES centre de camping (idCentre)');
        $this->addSql('CREATE INDEX IDX_910ED9BCA5B142EF ON camp_service (idCentre)');
        $this->addSql('ALTER TABLE centre de camping CHANGE idCentre idCentre INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idCentre)');
        $this->addSql('ALTER TABLE commande CHANGE idCommande idCommande INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idCommande)');
        $this->addSql('CREATE INDEX idUser ON commande (idUser)');
        $this->addSql('CREATE INDEX idProduit ON commande (idProduit)');
        $this->addSql('ALTER TABLE event CHANGE id id INT AUTO_INCREMENT NOT NULL, CHANGE idCentre idCentre INT DEFAULT NULL, ADD PRIMARY KEY (id)');
        $this->addSql('ALTER TABLE event ADD CONSTRAINT FK_3BAE0AA7A5B142EF FOREIGN KEY (idCentre) REFERENCES centre de camping (idCentre)');
        $this->addSql('CREATE INDEX IDX_3BAE0AA7A5B142EF ON event (idCentre)');
        $this->addSql('ALTER TABLE eventperso CHANGE idep idep INT AUTO_INCREMENT NOT NULL, CHANGE lieu location VARCHAR(255) NOT NULL, ADD PRIMARY KEY (idep)');
        $this->addSql('ALTER TABLE likepost CHANGE IdLike IdLike INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (IdLike)');
        $this->addSql('ALTER TABLE notifications CHANGE idNotif idNotif INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idNotif)');
        $this->addSql('CREATE INDEX idUser ON notifications (idUser)');
        $this->addSql('ALTER TABLE offre CHANGE idOffre idOffre INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idOffre)');
        $this->addSql('ALTER TABLE panier CHANGE idPanier idPanier INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idPanier)');
        $this->addSql('CREATE INDEX idUser ON panier (idUser)');
        $this->addSql('CREATE INDEX idProduit ON panier (idProduit)');
        $this->addSql('ALTER TABLE produit CHANGE idProduit idProduit INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idProduit)');
        $this->addSql('CREATE INDEX idActivite ON produit (idActivite)');
        $this->addSql('ALTER TABLE publications CHANGE idPub idPub INT AUTO_INCREMENT NOT NULL, CHANGE idUser idUser INT DEFAULT NULL, ADD PRIMARY KEY (idPub)');
        $this->addSql('ALTER TABLE publications ADD CONSTRAINT FK_32783AF4FE6E88D7 FOREIGN KEY (idUser) REFERENCES utilisateurs (idUser)');
        $this->addSql('CREATE INDEX publications_ibfk_1 ON publications (idUser)');
        $this->addSql('ALTER TABLE reclamation CHANGE idReclamation idReclamation INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idReclamation)');
        $this->addSql('CREATE INDEX idEvenement ON reclamation (idEvenement)');
        $this->addSql('ALTER TABLE resevation CHANGE idReservation idReservation INT AUTO_INCREMENT NOT NULL, CHANGE id id INT DEFAULT NULL, ADD PRIMARY KEY (idReservation)');
        $this->addSql('ALTER TABLE resevation ADD CONSTRAINT FK_6E8E407BBF396750 FOREIGN KEY (id) REFERENCES event (id)');
        $this->addSql('CREATE INDEX idUser ON resevation (idUser)');
        $this->addSql('CREATE INDEX fk3 ON resevation (id)');
        $this->addSql('ALTER TABLE servicecentre CHANGE idService idService INT AUTO_INCREMENT NOT NULL, CHANGE idCentre idCentre INT DEFAULT NULL, ADD PRIMARY KEY (idService)');
        $this->addSql('ALTER TABLE servicecentre ADD CONSTRAINT FK_E5EAEB0EA5B142EF FOREIGN KEY (idCentre) REFERENCES centre de camping (idCentre)');
        $this->addSql('CREATE INDEX fkj ON servicecentre (idCentre)');
        $this->addSql('ALTER TABLE ticket CHANGE idTicket idTicket INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idTicket)');
        $this->addSql('ALTER TABLE ticket ADD CONSTRAINT FK_97A0ADA3B842C572 FOREIGN KEY (idOffre) REFERENCES offre (idOffre)');
        $this->addSql('CREATE INDEX idReservation ON ticket (idReservation)');
        $this->addSql('CREATE INDEX fk5 ON ticket (idOffre)');
        $this->addSql('ALTER TABLE utilisateurs CHANGE idUser idUser INT AUTO_INCREMENT NOT NULL, ADD PRIMARY KEY (idUser)');
        $this->addSql('CREATE UNIQUE INDEX emailunique ON utilisateurs (email)');
        $this->addSql('CREATE UNIQUE INDEX Uniquecin ON utilisateurs (cinUser)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE event_user (id INT DEFAULT NULL, idUser INT NOT NULL, eventid INT NOT NULL) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('DROP TABLE blog');
        $this->addSql('ALTER TABLE activite MODIFY id INT NOT NULL');
        $this->addSql('ALTER TABLE activite DROP FOREIGN KEY FK_B87555153256915B');
        $this->addSql('DROP INDEX IDX_B87555153256915B ON activite');
        $this->addSql('ALTER TABLE activite DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE activite CHANGE id id INT NOT NULL, CHANGE relation_id nombre de participants INT DEFAULT NULL');
        $this->addSql('ALTER TABLE avis MODIFY idAvis INT NOT NULL');
        $this->addSql('ALTER TABLE avis DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idUser ON avis');
        $this->addSql('DROP INDEX idEvenement ON avis');
        $this->addSql('ALTER TABLE avis CHANGE idAvis idAvis INT NOT NULL');
        $this->addSql('ALTER TABLE camp_service DROP FOREIGN KEY FK_910ED9BCA5B142EF');
        $this->addSql('ALTER TABLE camp_service DROP PRIMARY KEY');
        $this->addSql('DROP INDEX IDX_910ED9BCA5B142EF ON camp_service');
        $this->addSql('ALTER TABLE centre de camping MODIFY idCentre INT NOT NULL');
        $this->addSql('ALTER TABLE centre de camping DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE centre de camping CHANGE idCentre idCentre INT NOT NULL');
        $this->addSql('ALTER TABLE commande MODIFY idCommande INT NOT NULL');
        $this->addSql('ALTER TABLE commande DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idUser ON commande');
        $this->addSql('DROP INDEX idProduit ON commande');
        $this->addSql('ALTER TABLE commande CHANGE idCommande idCommande INT NOT NULL');
        $this->addSql('ALTER TABLE event MODIFY id INT NOT NULL');
        $this->addSql('ALTER TABLE event DROP FOREIGN KEY FK_3BAE0AA7A5B142EF');
        $this->addSql('ALTER TABLE event DROP PRIMARY KEY');
        $this->addSql('DROP INDEX IDX_3BAE0AA7A5B142EF ON event');
        $this->addSql('ALTER TABLE event CHANGE id id INT NOT NULL, CHANGE idCentre idCentre INT NOT NULL');
        $this->addSql('ALTER TABLE eventperso MODIFY idep INT NOT NULL');
        $this->addSql('ALTER TABLE eventperso DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE eventperso CHANGE idep idep INT NOT NULL, CHANGE location lieu VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE likepost MODIFY IdLike INT NOT NULL');
        $this->addSql('ALTER TABLE likepost DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE likepost CHANGE IdLike IdLike INT NOT NULL');
        $this->addSql('ALTER TABLE notifications MODIFY idNotif INT NOT NULL');
        $this->addSql('ALTER TABLE notifications DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idUser ON notifications');
        $this->addSql('ALTER TABLE notifications CHANGE idNotif idNotif INT NOT NULL');
        $this->addSql('ALTER TABLE offre MODIFY idOffre INT NOT NULL');
        $this->addSql('ALTER TABLE offre DROP PRIMARY KEY');
        $this->addSql('ALTER TABLE offre CHANGE idOffre idOffre INT NOT NULL');
        $this->addSql('ALTER TABLE panier MODIFY idPanier INT NOT NULL');
        $this->addSql('ALTER TABLE panier DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idUser ON panier');
        $this->addSql('DROP INDEX idProduit ON panier');
        $this->addSql('ALTER TABLE panier CHANGE idPanier idPanier INT NOT NULL');
        $this->addSql('ALTER TABLE produit MODIFY idProduit INT NOT NULL');
        $this->addSql('ALTER TABLE produit DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idActivite ON produit');
        $this->addSql('ALTER TABLE produit CHANGE idProduit idProduit INT NOT NULL');
        $this->addSql('ALTER TABLE publications MODIFY idPub INT NOT NULL');
        $this->addSql('ALTER TABLE publications DROP FOREIGN KEY FK_32783AF4FE6E88D7');
        $this->addSql('ALTER TABLE publications DROP PRIMARY KEY');
        $this->addSql('DROP INDEX publications_ibfk_1 ON publications');
        $this->addSql('ALTER TABLE publications CHANGE idPub idPub INT NOT NULL, CHANGE idUser idUser INT NOT NULL');
        $this->addSql('ALTER TABLE reclamation MODIFY idReclamation INT NOT NULL');
        $this->addSql('ALTER TABLE reclamation DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idEvenement ON reclamation');
        $this->addSql('ALTER TABLE reclamation CHANGE idReclamation idReclamation INT NOT NULL');
        $this->addSql('ALTER TABLE resevation MODIFY idReservation INT NOT NULL');
        $this->addSql('ALTER TABLE resevation DROP FOREIGN KEY FK_6E8E407BBF396750');
        $this->addSql('ALTER TABLE resevation DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idUser ON resevation');
        $this->addSql('DROP INDEX fk3 ON resevation');
        $this->addSql('ALTER TABLE resevation CHANGE id id INT NOT NULL, CHANGE idReservation idReservation INT NOT NULL');
        $this->addSql('ALTER TABLE servicecentre MODIFY idService INT NOT NULL');
        $this->addSql('ALTER TABLE servicecentre DROP FOREIGN KEY FK_E5EAEB0EA5B142EF');
        $this->addSql('ALTER TABLE servicecentre DROP PRIMARY KEY');
        $this->addSql('DROP INDEX fkj ON servicecentre');
        $this->addSql('ALTER TABLE servicecentre CHANGE idService idService INT NOT NULL, CHANGE idCentre idCentre INT NOT NULL');
        $this->addSql('ALTER TABLE ticket MODIFY idTicket INT NOT NULL');
        $this->addSql('ALTER TABLE ticket DROP FOREIGN KEY FK_97A0ADA3B842C572');
        $this->addSql('ALTER TABLE ticket DROP PRIMARY KEY');
        $this->addSql('DROP INDEX idReservation ON ticket');
        $this->addSql('DROP INDEX fk5 ON ticket');
        $this->addSql('ALTER TABLE ticket CHANGE idTicket idTicket INT NOT NULL');
        $this->addSql('ALTER TABLE utilisateurs MODIFY idUser INT NOT NULL');
        $this->addSql('ALTER TABLE utilisateurs DROP PRIMARY KEY');
        $this->addSql('DROP INDEX emailunique ON utilisateurs');
        $this->addSql('DROP INDEX Uniquecin ON utilisateurs');
        $this->addSql('ALTER TABLE utilisateurs CHANGE idUser idUser INT NOT NULL');
    }
}
