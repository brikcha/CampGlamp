<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Likepost
 *
 * @ORM\Table(name="likepost")
 * @ORM\Entity
 */
class Likepost
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdLike", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idlike;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var int
     *
     * @ORM\Column(name="idPub", type="integer", nullable=false)
     */
    private $idpub;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateCreation", type="datetime", nullable=false, options={"default"="CURRENT_TIMESTAMP"})
     */
    private $datecreation = 'CURRENT_TIMESTAMP';


}
