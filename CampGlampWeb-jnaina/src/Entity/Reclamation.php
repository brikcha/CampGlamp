<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="idEvenement", columns={"idEvenement"})})
 * @ORM\Entity
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="idReclamation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idreclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="titreReclamation", type="string", length=255, nullable=false)
     */
    private $titrereclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionReclamation", type="string", length=100, nullable=false)
     */
    private $descriptionreclamation;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Reclamation_date", type="date", nullable=false)
     */
    private $reclamationDate;

    /**
     * @var int
     *
     * @ORM\Column(name="idEvenement", type="integer", nullable=false)
     */
    private $idevenement;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;


}
