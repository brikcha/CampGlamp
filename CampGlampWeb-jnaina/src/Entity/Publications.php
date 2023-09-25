<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Publications
 *
 * @ORM\Table(name="publications", indexes={@ORM\Index(name="publications_ibfk_1", columns={"idUser"})})
 * @ORM\Entity
 */
class Publications
{
    /**
     * @var int
     *
     * @ORM\Column(name="idPub", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpub;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionPub", type="string", length=50, nullable=false)
     */
    private $descriptionpub;

    /**
     * @var string
     *
     * @ORM\Column(name="sourcePub", type="string", length=200, nullable=false)
     */
    private $sourcepub;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateCreation", type="datetime", nullable=false, options={"default"="CURRENT_TIMESTAMP"})
     */
    private $datecreation = 'CURRENT_TIMESTAMP';

    /**
     * @var int
     *
     * @ORM\Column(name="nbrlikes", type="integer", nullable=false)
     */
    private $nbrlikes;

    /**
     * @var \Utilisateurs
     *
     * @ORM\ManyToOne(targetEntity="Utilisateurs")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idUser", referencedColumnName="idUser")
     * })
     */
    private $iduser;


}
