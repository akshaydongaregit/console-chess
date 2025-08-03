package com.chess.walk;

import com.chess.constants.PieceType;
import com.chess.exception.NotSupportedException;
import com.chess.walk.impl.KingWalk;
import com.chess.walk.impl.PawnWalk;
import com.chess.walk.impl.QueenWalk;

import java.util.HashMap;

public class WalkFactory {

    private static final HashMap<PieceType, Walk> pieceWalksMap = new HashMap<>() {{
        put(PieceType.PAWN, new PawnWalk());
        put(PieceType.KING, new KingWalk());
        put(PieceType.QUEEN, new QueenWalk());
    }};

    public static Walk getWalkForPiece(PieceType pieceType) throws NotSupportedException {
        Walk walk = pieceWalksMap.get(pieceType);
        if(walk==null)
            throw new NotSupportedException("Piece Type "+pieceType+" is not supported");
        return walk;
    }
}
