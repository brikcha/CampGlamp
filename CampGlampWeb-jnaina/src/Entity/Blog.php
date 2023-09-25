<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Eventperso
 *
 * @ORM\Table(name="eventperso")
 * @ORM\Entity
 */
class blog
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nomBlog", type="string", length=255, nullable=false)
     */
    private $nomBlog;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionBlog", type="string", length=255, nullable=false)
     */
    private $descriptionBlog;

    /**
     * @var string
     *
     * @ORM\Column(name="imageBlog", type="string", nullable=false)
     */
    private $imageBlog;


    

  //  /**
   //  * @var int
   //  *
   //  * @ORM\Column(name="iduser", type="integer", nullable=false)
  //   */
  //  private $iduser;


}
