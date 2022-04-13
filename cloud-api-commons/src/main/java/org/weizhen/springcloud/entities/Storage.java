package org.weizhen.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long id;

    private Long productId;

    private int total;

    private int used;

    private int residue;
}
